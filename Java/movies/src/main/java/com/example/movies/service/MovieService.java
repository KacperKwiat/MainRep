package com.example.movies.service;

import com.example.movies.dto.MovieDto;
import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.beans.BeanUtils.copyProperties;
@Slf4j
@Service

public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Cacheable("movies")
    public List<MovieDto> findAll(){
        log.info("MovieService: findAll");
        List<Movie> movies = movieRepository.getAll();
        List<MovieDto> moviesDtos = new ArrayList<>();
        for (Movie movie:movies){
            MovieDto movieDtos = new MovieDto();
            copyProperties(movie, movieDtos);
            moviesDtos.add(movieDtos);
        }
        return moviesDtos;
    }

    @Cacheable("movie")
    public MovieDto findById(Long id){
        log.info("MovieService: findById");
        Movie movie = movieRepository.getById(id);
        MovieDto movieDto = new MovieDto();
        copyProperties(movie,movieDto);
        return movieDto;
    }

    @Caching(evict = {
            @CacheEvict(value="movie", allEntries=true),
            @CacheEvict(value="movies", allEntries=true)})
    public int saveOrUpdate(MovieDto movieDto){
        log.info("MovieService: saveOrUpdate, {}", movieDto.getName());
        Movie movie = Movie.builder()
                .name(movieDto.getName())
                .genre(movieDto.getGenre())
                .posterURL(movieDto.getPosterURL())
                .build();

        if(movieDto.getId()!=null){
            movie.setId(movieDto.getId());
        }
        return movieRepository.save(movie);
    }
}
