package com.hotelService.HotelService.service.impl;

import com.hotelService.HotelService.entities.Hotel;
import com.hotelService.HotelService.exceptions.ResourceNotFoundException;
import com.hotelService.HotelService.repositories.HotelRepository;
import com.hotelService.HotelService.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("hotel with given id not found !!"));
    }
}
