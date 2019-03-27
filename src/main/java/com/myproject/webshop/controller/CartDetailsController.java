package com.myproject.webshop.controller;

import com.myproject.webshop.services.CartDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartDetailsController {

    @Autowired
    CartDetailsService service;

    @PostMapping("/cart/save/{userid}/{itemid}")
    public void saveCartDetails(@PathVariable Long userid, @PathVariable Long itemid) {
        service.createCartDetail(userid, itemid);
    }
}
