package com.userService.UserService.repositories;

import com.userService.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Author: Sapana Rimal
 * Date: 4/8/2024
 */
public interface UserRepository extends JpaRepository<User,Long> {
}
