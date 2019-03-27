package com.myproject.webshop.services;

import com.myproject.webshop.model.Cart;
import com.myproject.webshop.model.CartDetails;
import com.myproject.webshop.model.Item;
import com.myproject.webshop.model.User;
import com.myproject.webshop.repositories.CartDetailsRepository;
import com.myproject.webshop.repositories.ItemRepository;
import com.myproject.webshop.repositories.ShoppingCartRepo;
import com.myproject.webshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.persistence.EntityNotFoundException;

@Component
public class CartDetailsService {

    @Autowired
    CartDetailsRepository repository;
    @Autowired
    ShoppingCartRepo cartRepo;
    @Autowired
    ItemRepository itemRepo;
    @Autowired
    UserRepository userRepository;

    public void createCartDetail(Long userId, Long itemId){
        CartDetails details = new CartDetails();
        User user = userRepository.findUserById(userId);
        Cart cart = cartRepo.findByUser(user).orElseThrow(() -> new IllegalStateException("No form data HttpMessageReader."));
        Item item = itemRepo.findItemById(itemId);

        details.setCart(cart);
        details.setItem(item);

        repository.save(details);
    }

}
