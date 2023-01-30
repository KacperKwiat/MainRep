package com.example.movies.controller;

import com.example.movies.dto.RatingDto;
import com.example.movies.model.Rating;
import com.example.movies.repository.RatingRepository;
import com.example.movies.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin("http://loclahost:3000")
@RequestMapping("/movies")
public class RatingController {

    @Autowired
    RatingRepository ratingRepository;

    @Autowired
    RatingService ratingService;

    @GetMapping("/cachable/test/ratings/{id}")
    public ResponseEntity<List<RatingDto>> testFindAll(@PathVariable("id")Long id){
        log.info("RatingController: getByMovieId");
        List<RatingDto> ratingAll=ratingService.findAll(id);
        return new ResponseEntity<>(ratingAll, HttpStatus.OK);
    }

    @PostMapping(path = "/cachable/add/rating")
    public ResponseEntity<Long> createOrUpdate(@RequestBody RatingDto ratingDto) {
        log.info("RatingController: createOrUpdateRating");
        var rating = ratingService.saveOrUpdate(ratingDto);
        return new ResponseEntity<>((long)rating, HttpStatus.OK);
    }


    @GetMapping("/{id}/comments")
    public List<Rating> getByMovieId(@PathVariable("id")Long id){
        return ratingRepository.getByMovieId(id);
    }

    @PostMapping("/addComment")
    public int addRating(@RequestBody Rating rating){
        return ratingRepository.save(rating);
    }

    @PutMapping("/editComment/{id}")
    public int updateRating(@PathVariable("id") Long id, @RequestBody Rating rating){
        return ratingRepository.update(id, rating);
    }

    @DeleteMapping("/deleteComment/{id}")
    public int deletRating(@PathVariable("id") Long id){
        return ratingRepository.delete(id);
    }
}
