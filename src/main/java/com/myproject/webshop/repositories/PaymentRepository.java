package com.myproject.webshop.repositories;

import com.myproject.webshop.model.Payment;
import com.myproject.webshop.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p")
    List<Payment> findAllPayments();

    @Query("SELECT p FROM Payment p WHERE p.id=:id")
    Payment findPaymentById(@Param("id") Long id);

//    @Query("SELECT p FROM Payment p WHERE User p.id=:id")  //najti vse payments dlja 1 User po id? all Orders, all Items
//    List<Payment> findAllUserPayments(@Param("id")Long id);
}
