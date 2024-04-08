package com.userService.UserService.entities;

import lombok.*;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    private String ratingId;
    private Long userId;
    private String hotelId;
    private  int rating;
    private  String feedback;
    private Hotel hotel;

}
