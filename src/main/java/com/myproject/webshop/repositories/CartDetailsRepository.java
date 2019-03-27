package com.myproject.webshop.repositories;

import com.myproject.webshop.model.CartDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartDetailsRepository extends CrudRepository<CartDetails, Long> {
}
