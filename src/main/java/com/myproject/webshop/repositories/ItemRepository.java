package com.myproject.webshop.repositories;

import com.myproject.webshop.model.Item;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    @Query("SELECT i FROM Item i")
    List<Item> findAllItems();

    @Query("SELECT i FROM Item i WHERE i.id=:id")
    Item findItemById(@Param("id") Long id);

    @Query("SELECT cd.item FROM CartDetails cd WHERE cd.cart.id=?1")
    List<Item> findItemByCartId(@Param("id") Long id);

    @Query("SELECT q.item FROM CartDetails q WHERE q.item.id=:id")
    List<Item> findItemsQuantity(@Param("id") Long id);

}
