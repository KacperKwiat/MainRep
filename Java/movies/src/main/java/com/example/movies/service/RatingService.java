package com.example.movies.service;

import com.example.movies.dto.RatingDto;
import com.example.movies.model.Rating;
import com.example.movies.repository.RatingRepository;
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
public class RatingService {
    @Autowired
    RatingRepository ratingRepository;

    @Cacheable("Ratings")
    public List<RatingDto> findAll(Long id){
        log.info("RatingService: findAll");
        List<Rating> ratings = ratingRepository.getByMovieId(id);
        List<RatingDto> ratingsDtos = new ArrayList<>();
        for (Rating rating:ratings){
            RatingDto ratingDtos = new RatingDto();
            copyProperties(rating, ratingDtos);
            ratingsDtos.add(ratingDtos);
        }
        return ratingsDtos;
    }



    @Caching(evict = {
            @CacheEvict(value="Rating", allEntries=true),
            @CacheEvict(value="Ratings", allEntries=true)})
    public int saveOrUpdate(RatingDto ratingDto){
        log.info("RatingService: saveOrUpdate, {}", ratingDto.getId());
        Rating rating = Rating.builder()
                .movieId(ratingDto.getMovieId())
                .userId(ratingDto.getUserId())
                .review(ratingDto.getReview())
                .ratingGrade(ratingDto.getRatingGarde())
                .build();


        return ratingRepository.save(rating);
    }
}
