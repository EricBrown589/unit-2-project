package com.banking.bankingapi.repository;

import com.banking.bankingapi.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
//  Account findByName(String categoryName);

  List<Account> findByUserId(Long userId);

  Account findByIdAndUserId(Long userId, Long accountId);

  double findAllBalanceById(Long accountId);

//  Account findByUserIdAndName(Long userId, String categoryName);
}
