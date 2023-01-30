package com.example.movies.controller;

import com.example.movies.dto.MovieDto;
import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import com.example.movies.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/movies")
@CrossOrigin("http://localhost:3000/")
public class   MovieController {
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieService movieService;

    @GetMapping("/cachable/test")
    public ResponseEntity<List<MovieDto>>testFindAll(){
        log.info("MovieController: FindALL");
        List<MovieDto> moviesAll=movieService.findAll();
        return new ResponseEntity<>(moviesAll, HttpStatus.OK);
    }

    @GetMapping(path = "/cachable/{id}")
    public ResponseEntity<MovieDto> getMovie(@PathVariable Long id) {
        log.info("MovieController: getMovieByID");
        MovieDto movie = movieService.findById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping(path = "/cachable/add")
    public ResponseEntity<Long> createOrUpdate(@RequestBody MovieDto movieDto) {
        log.info("MovieController: createOrUpdateMovie");
        var movie = movieService.saveOrUpdate(movieDto);
        return new ResponseEntity<>((long)movie, HttpStatus.OK);
    }



    @CrossOrigin("http://localhost:3000/")
    @GetMapping("")
    public List<Movie> getAll(){
        log.info("MovieController : getAllNormal");
        return movieRepository.getAll();
    }


    @GetMapping("/{id}")
    public Movie getById(@PathVariable("id") Long id){
        return movieRepository.getById(id);
    }

    @CrossOrigin("http://localhost:3000/addMovies")
    @PostMapping("/addMovies")
    public int addMovie(@RequestBody Movie movies){
        return movieRepository.save(movies);
    }
    @CrossOrigin
    @PutMapping("/edit/{id}")
    public int update(@PathVariable("id")Long id, @RequestBody Movie updatedMovie){
        return movieRepository.update(id, updatedMovie);

    }
    @CrossOrigin
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> delete(@PathVariable("id")Long id){
        String name=movieRepository.getById(id).getName();
        String response=movieRepository.delete(id);
        return new ResponseEntity<>(response+" "+name, HttpStatus.OK);
    }
}
