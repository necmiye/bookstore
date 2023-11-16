package com.bookstore.bookstore.Config;

import com.bookstore.bookstore.dto.UserDtoConverter;
import com.bookstore.bookstore.repositories.BookRepository;
import com.bookstore.bookstore.repositories.UserRepository;
import com.bookstore.bookstore.services.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean(name="bookServiceClass")
    public IBookService bookService(BookRepository bookRepository){
        return new BookServiceImpl(bookRepository);
    }
    @Bean(name="userServiceClass")
    public IUserService userService(UserRepository userRepository, UserDtoConverter userDtoConverter){
        return new UserServiceImpl(userRepository, userDtoConverter);
    }

    @Bean(name="orderServiceClass")
    public IOrderService orderService(){
        return new OrderServiceImpl();
    }
}
