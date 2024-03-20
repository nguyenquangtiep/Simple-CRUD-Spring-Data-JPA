package com.mark.simplecrudspringdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long accountId;
    private String accountHolderName;
    private Double accountBalance;
}
