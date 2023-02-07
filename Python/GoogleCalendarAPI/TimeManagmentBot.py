from __future__ import print_function

import datetime
import os.path
from sys import argv
import sqlite3

from dateutil.parser import parse
from googleapiclient.discovery import build
from google.auth.transport.requests import Request
from google.oauth2.credentials import Credentials
from google_auth_oauthlib.flow import InstalledAppFlow


from googleapiclient.errors import HttpError




SCOPES = ['https://www.googleapis.com/auth/calendar']


def main():
    """Shows basic usage of the Google Calendar API.
    Prints the start and name of the next 10 events on the user's calendar.
    """
    creds = None
    # The file token.json stores the user's access and refresh tokens, and is
    # created automatically when the authorization flow completes for the first
    # time.
    if os.path.exists('token.json'):
        creds = Credentials.from_authorized_user_file('token.json', SCOPES)
    # If there are no (valid) credentials available, let the user log in.
    if not creds or not creds.valid:
        if creds and creds.expired and creds.refresh_token:
            creds.refresh(Request())
        else:
            flow = InstalledAppFlow.from_client_secrets_file(
                'credentials.json', SCOPES)
            creds = flow.run_local_server(port=0)
        # Save the credentials for the next run
        with open('token.json', 'w') as token:
            token.write(creds.to_json())

    # if argv[1] == 'add':
    #     duration = argv[2]                                #for creating and adding events from normal command line + need to create aliases
    #     description = argv[3]
    #     addingEvent(creds, duration, description)
    #
    # if argv[1] == 'commit':
    #     commitHours(creds)
    addingEvent(creds, 2, "Create something new")
    commitHours(creds)




def commitHours(creds):
    try:
        service = build('calendar', 'v3', credentials=creds)

        # Call the Calendar API

        today = datetime.date.today()
        # timeStart=(today+datetime.timedelta(hours=0)).isoformat()+'Z'
        # timeEnd=(today+datetime.timedelta(days=1)).isoformat()+'Z' # 'Z' indicates UTC time
        timeStart=str(today)+"T00:00:00Z"
        timeEnd=str(today)+"T23:59:59Z"
        print('Getting the upcoming events')
        events_result = service.events().list(calendarId='primary',
                                              timeMin=timeStart,
                                              timeMax=timeEnd,
                                              singleEvents=True,
                                              orderBy='startTime',
                                              timeZone='Europe/Warsaw').execute()
        events = events_result.get('items', [])

        if not events:
            print('No upcoming events found.')
            return

        # Prints the start and name of the next 10 events
        total_duration = datetime.timedelta(
            seconds=0,
            minutes=0,
            hours=0,
        )

        print("Events: ")
        for event in events:
            start=event['start'].get('dateTime', event['start'].get('date'))
            end=event['end'].get('dateTime', event['end'].get('date'))

            new_start=parse(start)
            new_end=parse(end)
            duration=new_end-new_start
            total_duration+=duration
            print(f"{event['summary']}, duration: {duration}, start date: {start}, end date: {end}")

        conn = sqlite3.connect(f'hours.db')
        cur = conn.cursor()
        print("Opened database successfully")
        date = datetime.date.today()
        formatted_total_duration = int(total_duration.seconds/60/60)

        coding_hours=(date, 'Coding', formatted_total_duration)
        cur.execute("Insert Into hours Values(?, ?, ?);", coding_hours)
        conn.commit()
        print("Hours successfully added")
    except HttpError as error:
        print('An error occurred: %s' % error)

def addingEvent(creds, duration, description):
    start = datetime.datetime.utcnow()

    end = datetime.datetime.utcnow() + datetime.timedelta(hours=int(duration))
    start_formatted=start.isoformat() + 'Z'
    end_formatted = end.isoformat() + 'Z'

    event = {
        'summary': description,
        'start':{
            'dateTime': start_formatted,
            'timeZone': 'Europe/Warsaw',
        },
        'end':{
            'dateTime': end_formatted,
            'timeZone': 'Europe/Warsaw',
        },
    }

    service = build('calendar', 'v3', credentials=creds)
    event = service.events().insert(calendarId='primary', body=event).execute()
    print('Event created: %s'%(event.get('htmlLink')))





    # except HttpError as error:
    #     print('An error occurred: %s' % error)


if __name__ == '__main__':
    main()

