package com.myproject.webshop.mapper;

import com.myproject.webshop.dto.AccountDTO;
import com.myproject.webshop.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

    public AccountDTO toDto(Account account) {

        return new AccountDTO(account.getAccId(), account.getBillingAddress(), account.getOpenDate(), account.getClosedDate());
    }


    public List<AccountDTO>toDtoList(List<Account> accounts) {

        List<AccountDTO>accountDTOS = new ArrayList<>();

        for (Account account: accounts) {
            accountDTOS.add((toDto(account)));
        }
        return accountDTOS;
    }

    public Account toEntity(AccountDTO accountDTO) {

        return new Account(accountDTO.getAccId(), accountDTO.getBillingAdress(), accountDTO.getOpenDate(), accountDTO.getClosedDate());
    }


    public List<Account>toEntityList(List<AccountDTO> accountDTOList) {

        List<Account>accountEntityList = new ArrayList<>();

        for(AccountDTO accountDTO: accountDTOList) {
            accountEntityList.add((toEntity(accountDTO)));
        }

        return accountEntityList;
    }

    public Account updateAccount(AccountDTO accountDTO, Account account) {

        account.setBillingAddress(accountDTO.getBillingAdress());

        return account;
    }

}
