package com.myproject.webshop.controller;

import com.myproject.webshop.dto.ItemDto;
import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.Item;
import com.myproject.webshop.model.User;
import com.myproject.webshop.services.CartService;
import com.myproject.webshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    CartService service;
    @Autowired
    UserService userService;
    @Autowired
    UserMapper mapper;

    @PostMapping("/cart/{id}")
    public void save(@PathVariable Long id) {


        UserDTO dto = userService.findById(id);
        User user = mapper.toEntity(dto);
        service.createCart(user);
    }

    @PostMapping("/cart/sumprice/{user}")
    public double sumCartPrice(@PathVariable User user) { return service.sumCartPrice(user); }
}
