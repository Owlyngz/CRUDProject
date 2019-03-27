package com.myproject.webshop.repositories;

import com.myproject.webshop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@org.springframework.stereotype.Repository
public interface UserRepository extends CrudRepository<User, Long> {


    @Query("SELECT u FROM User u")
    List<User> findAllUsers();

    @Query("SELECT u FROM User u WHERE u.id=:id")
    User findUserById(@Param("id") Long id);

}
