package com.mark.simplecrudspringdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @Column(name = "balance")
    private Double accountBalance;
}
