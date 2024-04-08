package com.userService.UserService.response;
import lombok.*;
import org.springframework.http.HttpStatus;
/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

}