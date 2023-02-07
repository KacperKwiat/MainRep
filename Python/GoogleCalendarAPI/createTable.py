import sqlite3

conn = sqlite3.connect(f'hours.db')
cur = conn.cursor()
print("Opened database successfully")

conn.execute('''Create Table if not exists hours 
    (Date Date Not Null,
    Category Text Not Null,
    Hours INT Not Null);''')

print("Table has been created")