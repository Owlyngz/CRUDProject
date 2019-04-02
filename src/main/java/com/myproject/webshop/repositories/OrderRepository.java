package com.myproject.webshop.repositories;


import com.myproject.webshop.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query("SELECT o FROM Order o")
    List<Order> findAllOrders();

    @Query("SELECT o FROM Order o WHERE o.id=:id")
    Order findOrderById(@Param("id") Long id);

    String FIND_ORDERS = "SELECT orderId, userSurname FROM User";
    @Query(value = FIND_ORDERS, nativeQuery = true)
    List<Object[]> findOrders();
}
