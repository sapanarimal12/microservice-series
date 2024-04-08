package com.hotelService.HotelService.service;

import com.hotelService.HotelService.entities.Hotel;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public interface HotelService {

    //create

    Hotel create(Hotel hotel);

    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);
}
