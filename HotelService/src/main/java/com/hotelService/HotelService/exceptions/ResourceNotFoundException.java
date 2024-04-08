package com.hotelService.HotelService.exceptions;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String s) {
        super(s);
    }

    public ResourceNotFoundException(){
        super("Resource not found !!");
    }
}