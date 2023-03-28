package com.kacperk.emailservice.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){super("Didn t find any matching users please try again");}
}
