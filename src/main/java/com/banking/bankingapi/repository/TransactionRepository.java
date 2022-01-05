//package com.banking.bankingapi.repository;
//
//import com.banking.bankingapi.model.Transaction;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//  Transaction findByName(String itemName);
//  Transaction findByNameAndIdIsNot(String itemName, Long itemId);
//  List<Transaction> findByAccountId(Long itemId);
//  Transaction findByIdAndUserId(Long transactionId, Long userId);
//  Transaction findByIdAndUserIdAndIdIsNot(String name, Long id, Long itemId);
//}
