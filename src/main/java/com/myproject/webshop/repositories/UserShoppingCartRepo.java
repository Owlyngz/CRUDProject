package com.myproject.webshop.repositories;

import com.myproject.webshop.model.Item;
import org.springframework.data.repository.CrudRepository;

public interface UserShoppingCartRepo extends CrudRepository<Item, Long> {
}
