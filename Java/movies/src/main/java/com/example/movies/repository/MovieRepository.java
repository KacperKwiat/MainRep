package com.example.movies.repository;


import com.example.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MovieRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Movie> getAll(){
        return jdbcTemplate.query("Select id, name, genre, posterURL From movie", BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getById(Long id){
        return jdbcTemplate.queryForObject("select id, name, genre, posterURL from movie where id= ? ",
                BeanPropertyRowMapper.newInstance(Movie.class),
                id);
    }

    public int save(Movie movie) {
        return jdbcTemplate.update("insert into movie(name, genre, posterURL) values (?,?,?)",
                        movie.getName(),
                        movie.getGenre(),
                        movie.getPosterURL()
                );

    }

    public int update(Long id, Movie movie){
        return jdbcTemplate.update("update movie set name=?, genre=?, posterURL=? where id=?",
                movie.getName(),
                movie.getGenre(),
                movie.getPosterURL(),
                id);

    }

    public String delete(Long id){
        jdbcTemplate.update("delete from movie where id=?", id);
        return "Movie succesfully deleted";
    }
}
