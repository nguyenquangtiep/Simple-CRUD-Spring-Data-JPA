package com.mark.simplecrudspringdatajpa.controller;

import com.mark.simplecrudspringdatajpa.dto.AccountDto;
import com.mark.simplecrudspringdatajpa.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@AllArgsConstructor
public class AccountController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
        AccountDto createdAccount = accountService.createAccount(accountDto);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable("id") Long accountId) {
        AccountDto accountDto = accountService.getAccountById(accountId);
        return new ResponseEntity<>(accountDto, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable("id") Long accountId, @RequestBody AccountDto accountDto) {
        AccountDto savedAccount = accountService.updateAccount(accountId, accountDto);
        return new ResponseEntity<>(savedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable("id") Long accountId) {
        accountService.deleteAccount(accountId);
        return new ResponseEntity<>("Account deleted successfully!", HttpStatus.OK);
    }
}
