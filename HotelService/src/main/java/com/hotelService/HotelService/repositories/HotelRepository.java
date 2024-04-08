package com.hotelService.HotelService.repositories;

import com.hotelService.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public interface HotelRepository extends JpaRepository<Hotel, String> {
}
