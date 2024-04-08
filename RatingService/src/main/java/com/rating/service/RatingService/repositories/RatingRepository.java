package com.rating.service.RatingService.repositories;

import com.rating.service.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/3/2024
 */
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByUserId(Long userId);
    List<Rating> findByHotelId(Long hotelId);

}
