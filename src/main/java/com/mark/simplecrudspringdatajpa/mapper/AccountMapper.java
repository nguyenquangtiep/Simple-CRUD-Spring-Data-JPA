package com.mark.simplecrudspringdatajpa.mapper;

import com.mark.simplecrudspringdatajpa.dto.AccountDto;
import com.mark.simplecrudspringdatajpa.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        return new Account(
                accountDto.getAccountId(),
                accountDto.getAccountHolderName(),
                accountDto.getAccountBalance()
        );
    }

    public static AccountDto mapToAccountDto(Account account) {
        return new AccountDto(
                account.getAccountId(),
                account.getAccountHolderName(),
                account.getAccountBalance()
        );
    }

}
