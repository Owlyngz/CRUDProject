package com.myproject.webshop.controller;

import com.myproject.webshop.dto.AccountDTO;
import com.myproject.webshop.model.Account;
import com.myproject.webshop.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public List<AccountDTO> allAccounts() { return accountService.getAllDTOAccounts(); }

    public AccountDTO findById(@PathVariable Long id) { return accountService.findAccountById(id); }

    @PostMapping("/account")
    public List<AccountDTO> saveOrder(@RequestBody Account account) { return accountService.saveMethod(account); }

    @DeleteMapping("/accounts/{id}")
    public List<AccountDTO> deleteAccount(@PathVariable Long id) { return accountService.deleteAccountById(id); }

    @PutMapping("/accounts/{id}/put")
    public AccountDTO updateAccount(@RequestBody AccountDTO accountDTO, @PathVariable Long id) { return accountService.updateMethod(accountDTO, id); }

}
