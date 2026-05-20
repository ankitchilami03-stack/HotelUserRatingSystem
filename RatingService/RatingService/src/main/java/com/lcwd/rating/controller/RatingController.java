package com.lcwd.rating.controller;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController
{
    @Autowired
    RatingService ratingService;
    //create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }
    //get all
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings()
    {
        return ResponseEntity.ok(ratingService.getRatings());
    }

    //get all
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingsUserId(@PathVariable String userId)
    {
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

    //get all
    @GetMapping("/hotels/{hotelId}")

    public ResponseEntity<List<Rating>> getRatingsHotelId(@PathVariable  String hotelId)
    {
        return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
    }

}
