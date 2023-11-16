package com.bookstore.bookstore.services;

import com.bookstore.bookstore.dto.UserDto;
import com.bookstore.bookstore.entities.User;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IUserService {
    public boolean save(User user);
    User getUserById(Long userId);
    User signUp(User user, Set<String> roleNames);
}
