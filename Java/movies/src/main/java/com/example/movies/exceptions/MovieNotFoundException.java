package com.example.movies.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(Long id) {
        super("Didnt find the movie of id "+id);
    }
}
