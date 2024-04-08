package com.userService.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    private  String id;
    private  String name;
    private  String location;
    private  String about;

}