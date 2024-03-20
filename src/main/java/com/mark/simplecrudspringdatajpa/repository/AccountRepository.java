package com.mark.simplecrudspringdatajpa.repository;

import com.mark.simplecrudspringdatajpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
