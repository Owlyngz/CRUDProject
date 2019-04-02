package com.myproject.webshop.services;

import com.myproject.webshop.dto.UserDTO;
import com.myproject.webshop.mapper.UserMapper;
import com.myproject.webshop.model.Cart;
import com.myproject.webshop.model.CartDetails;
import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.ItemRepository;
import com.myproject.webshop.repositories.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class CartService {

    @Autowired
    ShoppingCartRepo repo;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private UserMapper userMapper;

    public long createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);

        return repo.save(cart).getId();
    }

    public double sumCartPrice(UserDTO userDTO) {

        double price = 0;

        User user = userMapper.toEntity(userDTO);

        Cart cart = repo.findByUser(user).orElseThrow(() -> new IllegalStateException("No form data HttpMessageReader."));
        for (CartDetails cartDetails : cart.getCartDetailsList()) {
            price += cartDetails.getItem().getPrice();
        }
        return price;

    }
}

