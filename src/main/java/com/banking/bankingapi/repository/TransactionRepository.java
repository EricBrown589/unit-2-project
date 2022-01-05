package com.banking.bankingapi.repository;

import com.banking.bankingapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByIdAndUserId(Long accountId, Long UserId);
}
