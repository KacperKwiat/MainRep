package com.example.movies.dto;

import lombok.Data;

@Data
public class RatingDto {
    private Long id;
    private Long userId;
    private Long movieId;
    private String review;
    private int ratingGarde;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getRatingGarde() {
        return ratingGarde;
    }

    public void setRatingGarde(int ratingGarde) {
        this.ratingGarde = ratingGarde;
    }
}
