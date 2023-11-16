package com.bookstore.bookstore.dto;

import com.bookstore.bookstore.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    public UserDto convert (User user){
        return new UserDto(
               user.getId(),
               user.getEmail(),
               user.getName(),
               user.getPassword(),
               user.getCreatedAt(),
               user.getUpdatedAt());
    }
}
