package com.rating.service.RatingService.controller;

import com.rating.service.RatingService.entities.Rating;
import com.rating.service.RatingService.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */

@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating saveRating = ratingService.create(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRating() {
        List<Rating> RatingList = ratingService.getAllRatings();
        return ResponseEntity.ok(RatingList);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable Long userId) {
        List<Rating> ratingList = ratingService.getRatingByUserId(userId);
        return ResponseEntity.ok(ratingList);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable Long hotelId) {
        List<Rating> ratingList = ratingService.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingList);
    }
}
