package com.rating.service.RatingService.service;

import com.rating.service.RatingService.entities.Rating;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */
public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getAllRatings();

    List<Rating> getRatingByUserId(Long userId);

    List<Rating> getRatingByHotelId(Long hotelId);

}
