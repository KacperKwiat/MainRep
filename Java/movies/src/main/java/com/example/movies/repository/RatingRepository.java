package com.example.movies.repository;

import com.example.movies.model.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RatingRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Rating> getByMovieId(Long id){
        return jdbcTemplate.query("select userId, review, ratingGrade from rating where movieId= ? ",
                BeanPropertyRowMapper.newInstance(Rating.class),
                id);
    }

    public int save(Rating rating) {
        jdbcTemplate.update("insert into rating(userId, movieId, review, ratingGrade) values (?,?,?,?)",
                rating.getUserId(),
                rating.getMovieId(),
                rating.getReview(),
                rating.getRatingGrade()
        );

        return 1;
    }

    public int update(Long id, Rating newRating){
        return jdbcTemplate.update("update rating set review=?, ratingGrade=?, where movieId=?",
                newRating.getReview(),
                newRating.getRatingGrade(),
                id);
    }

    public int delete(Long id){
        return jdbcTemplate.update("delete from rating where id=?", id);
    }
}
