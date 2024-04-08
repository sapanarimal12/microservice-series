package com.hotelService.HotelService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */


@RestController
@RequestMapping("/staffs")
public class StaffController {


    @GetMapping
    public ResponseEntity<List<String>> getStaffs() {
        List<String> list = Arrays.asList("Ram", "Shyam", "Sita", "Krishna");
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
