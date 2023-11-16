package com.bookstore.bookstore.security;

import com.bookstore.bookstore.entities.RoleName;
import com.bookstore.bookstore.entities.User;
import com.bookstore.bookstore.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Service
public class UserDetailService implements org.springframework.security.core.userdetails.UserDetailsService{
    private UserRepository userRepository;
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(username);
        Collection<User> users = userRepository.findAll();
        if(users.contains(user)){
            return new org.springframework.security.core.userdetails.User(username,user.get().getPassword(), new ArrayList<>());
        }
        throw new UsernameNotFoundException(username);
    }
}
