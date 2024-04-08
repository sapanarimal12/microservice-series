package com.userService.UserService.services;

import com.userService.UserService.entities.User;

import java.util.List;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public interface UserService {


    //create
    User saveUser(User user);

    //get all user
    List<User> getAllUser();

    //get single user of given userId

    User getUser(Long userId);
}
