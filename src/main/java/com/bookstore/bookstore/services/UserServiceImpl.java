package com.bookstore.bookstore.services;

import com.bookstore.bookstore.dto.BookDtoConverter;
import com.bookstore.bookstore.dto.UserDto;
import com.bookstore.bookstore.dto.UserDtoConverter;
import com.bookstore.bookstore.entities.Role;
import com.bookstore.bookstore.entities.RoleName;
import com.bookstore.bookstore.entities.User;
import com.bookstore.bookstore.exception.UserNotFoundException;
import com.bookstore.bookstore.repositories.RoleRepository;
import com.bookstore.bookstore.repositories.UserRepository;
import com.bookstore.bookstore.security.CustomPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private CustomPasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, UserDtoConverter userDtoConverter){
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }
    @Override
    public boolean save(User user) {
        userRepository.save(user);
        return true;
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User signUp(User user, Set<String> roleNames) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use!");
        }
        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
        // Set user roles
        Set<Role> roles = new HashSet<>();
        for (String roleName : roleNames) {
            Role role = roleRepository.findByName(RoleName.valueOf(roleName))
                    .orElseThrow(() -> new RuntimeException("Role not found: " + roleName));
            roles.add(role);
        }
        user.setRoles(roles);
        return userRepository.save(user);
    }
}
