package com.userService.UserService.exceptions;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public class ResourceNotFoundException extends RuntimeException {

    //extra properties that you want to mange
    public ResourceNotFoundException() {
        super("Resource not found on server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
