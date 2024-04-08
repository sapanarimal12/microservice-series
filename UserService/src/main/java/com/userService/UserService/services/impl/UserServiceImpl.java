package com.userService.UserService.services.impl;

import com.userService.UserService.entities.Hotel;
import com.userService.UserService.entities.Rating;
import com.userService.UserService.entities.User;
import com.userService.UserService.exceptions.ResourceNotFoundException;
import com.userService.UserService.external.services.HotelService;
import com.userService.UserService.repositories.UserRepository;
import com.userService.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        // Make a POST request to the RATING-SERVICE to save ratings for the user

        Rating ratingsOfUser = webClientBuilder
                .build()
                .post()
                .uri("http://RATING-SERVICE/ratings")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .bodyValue(getRequest(user))
                .retrieve()
                .bodyToMono(Rating.class)
                .block();

        logger.info("Ratings :: {}", ratingsOfUser);

        return userRepository.save(user);
    }

    private Rating getRequest(User user){
        Rating rating = new Rating();
        rating.setUserId(user.getUserId());
        rating.setRating(5);
        rating.setFeedback("Need to improve the food quality.");
        return rating;
    }
    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE

//        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);

        Rating[] ratingsOfUser = webClientBuilder
                .build()
                .get()
                .uri("http://RATING-SERVICE/ratings/users/" + user.getUserId())
                .retrieve()
                .bodyToMono(Rating[].class)
                .block();
        logger.info("{} ", ratingsOfUser);
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
             logger.info("response status code: {} ",hotel);

            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);

        return user;
    }
}
