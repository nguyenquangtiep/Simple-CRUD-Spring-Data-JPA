package com.mark.simplecrudspringdatajpa.service.impl;

import com.mark.simplecrudspringdatajpa.dto.AccountDto;
import com.mark.simplecrudspringdatajpa.entity.Account;
import com.mark.simplecrudspringdatajpa.exception.AccountNotFoundException;
import com.mark.simplecrudspringdatajpa.mapper.AccountMapper;
import com.mark.simplecrudspringdatajpa.repository.AccountRepository;
import com.mark.simplecrudspringdatajpa.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account =accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + accountId));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
    }

    @Override
    public AccountDto updateAccount(Long accountId, AccountDto accountDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + accountId));
        account.setAccountHolderName(accountDto.getAccountHolderName());
        account.setAccountBalance(accountDto.getAccountBalance());
        Account updatedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(updatedAccount);
    }

    @Override
    public void deleteAccount(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found with id " + accountId));
        accountRepository.delete(account);
    }
}
