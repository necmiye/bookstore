package com.bookstore.bookstore.controllers;

import com.bookstore.bookstore.dto.OrderDto;
import com.bookstore.bookstore.entities.Order;
import com.bookstore.bookstore.services.IOrderService;
import com.bookstore.bookstore.services.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class Ordercontroller {

    private IOrderService orderService;
    @Autowired
    public Ordercontroller(@Qualifier("orderServiceClass")IOrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderRequest) {
        Order newOrder = orderService.placeOrder(orderRequest);
        return ResponseEntity.ok(newOrder);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Order>> getUserOrders(@PathVariable Long userId) {
        List<Order> userOrders = orderService.getUserOrders(userId);
        return ResponseEntity.ok(userOrders);
    }

//    @GetMapping("/details/{orderId}")
//    public ResponseEntity<OrderDetails> getOrderDetails(@PathVariable Long orderId) {
//        OrderDetails orderDetails = orderService.getOrderDetails(orderId);
//        return ResponseEntity.ok(orderDetails);
//    }
}
