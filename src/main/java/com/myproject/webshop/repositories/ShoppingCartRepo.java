package com.myproject.webshop.repositories;

import com.myproject.webshop.model.Cart;
import com.myproject.webshop.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepo extends CrudRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);

}
