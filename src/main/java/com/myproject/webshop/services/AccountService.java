package com.myproject.webshop.services;

import com.myproject.webshop.dto.AccountDTO;
import com.myproject.webshop.mapper.AccountMapper;
import com.myproject.webshop.model.Account;
import com.myproject.webshop.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Component
public class AccountService {

    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    public AccountService(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public List<AccountDTO> getAllDTOAccounts() {

        List<Account> foundAccounts = accountRepository.findAllAccounts();
        return accountMapper.toDtoList(foundAccounts);

    }

    public List<AccountDTO> saveMethod(Account account) {

        accountRepository.save(account);
        return getAllDTOAccounts();
    }

    public AccountDTO findAccountById(Long id) {

        AccountDTO accountDTO = accountMapper.toDto(accountRepository.findAccountById(id));
        return accountDTO;
    }

    public AccountDTO updateMethod(AccountDTO accountDTO, Long id) {

        Account foundAccount = accountRepository.findAccountById(id);

        accountMapper.updateAccount(accountDTO, foundAccount);

        saveMethod(foundAccount);

        return findAccountById(id);

    }

    public List<AccountDTO> deleteAccountById (Long id) {

        if (id == null) {
            throw new HttpClientErrorException(HttpStatus.METHOD_NOT_ALLOWED);
        }
        if (id == 0) {
            throw new HttpClientErrorException(HttpStatus.I_AM_A_TEAPOT);
        }
        accountRepository.deleteById(id);
        return getAllDTOAccounts();
    }

}
