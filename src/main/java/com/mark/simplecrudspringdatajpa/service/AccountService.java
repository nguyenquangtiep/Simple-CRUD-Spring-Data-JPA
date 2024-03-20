package com.mark.simplecrudspringdatajpa.service;

import com.mark.simplecrudspringdatajpa.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto getAccountById(Long accountId);
    List<AccountDto> getAllAccounts();
    AccountDto updateAccount(Long accountId, AccountDto accountDto);
    void deleteAccount(Long accountId);
}
