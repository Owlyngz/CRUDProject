package com.myproject.webshop.repositories;

import com.myproject.webshop.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("SELECT a FROM Account a")
    List<Account> findAllAccounts();

    @Query("SELECT a FROM Account a WHERE a.id=:id")
    Account findAccountById(@Param("id") Long id);
}

