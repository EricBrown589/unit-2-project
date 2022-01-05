package com.banking.bankingapi.repository;

import com.banking.bankingapi.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findByIdAndUserId(Long accountId, Long UserId);

    Optional<Transaction> findByAccountId(Long accountId);

//    Transaction findByIdAndUserIdAndTransactionId(Long accountId, Long UserId, Long transactionId);
//    Transaction findByAccountIdAndId(Long accountId, Long transactionId);
//    Transaction findByAccountIdAndIdAndDescription(Long accountId, Long transactionId, String transactionDescription);
    Transaction findByIdAndUserIdAndIdIsNot(Long accountId, Long userId, Long transactionId);
}

