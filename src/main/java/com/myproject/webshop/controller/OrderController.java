package com.myproject.webshop.controller;

import com.myproject.webshop.dto.OrderDTO;
import com.myproject.webshop.model.Order;
import com.myproject.webshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {


    @Autowired
    OrderService orderService;

    @GetMapping("/orders")
    public List<OrderDTO> allOrders() { return orderService.getAllDtoOrders(); }

    @GetMapping("/orders/{id}")
    public OrderDTO findOrderById(@PathVariable Long id) { return orderService.findOrderById(id); }

    @PostMapping("/order")
    public List<OrderDTO> saveOrder(@RequestBody Order order) { return orderService.saveMethod(order); }

    @DeleteMapping("/orders/{id}")
    public List<OrderDTO> deleteOrder(@PathVariable Long id) { return  orderService.deleteOrderById(id); }

    @PutMapping("/orders/{id}/put")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO, @PathVariable Long id) { return orderService.updateMethod(orderDTO, id); }
}