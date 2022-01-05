package com.banking.bankingapi.service;

import com.banking.bankingapi.exception.InformationExistsException;
import com.banking.bankingapi.exception.InformationNotFoundException;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.repository.AccountRepository;
import com.banking.bankingapi.repository.TransactionRepository;
import com.banking.bankingapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountService {

  private AccountRepository accountRepository;
 private TransactionRepository transactionRepository;


  private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

  @Autowired
  // creates a bean (single instance) of the account Repository to call and link the methods to the controller
  public void setAccountRepository(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  // creates java bean (single instance)
  @Autowired
  public void setTransactionRepository(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }







//  *******************   ACCOUNTS COMPLETED   *******************

  //  *** GET SPECIFIC ACCOUNT BY ID
  //  passed variable will point to and transaction in the database
  public Account getAccount(Long accountId) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("Calling `getAccount` from `AccountService`...");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    if (account == null) {
      throw new InformationNotFoundException("account with id " + accountId + " not found");
    } else {
      return account;
    }
  }

  // *** GET ALL ACCOUNTS
  public List<Account> getAccounts() {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("Retrieving Accounts From Service...");
    System.out.println(userDetails.getUser().getId());
    List<Account> accounts = accountRepository.findByUserId(userDetails.getUser().getId());
    if (accounts.isEmpty()) {
      throw new InformationNotFoundException("No Accounts found for user: " + userDetails.getUser().getId());
    } else {
      return accounts;
    }
  }

  //  *** CREATE ACCOUNT
  public Account createAccount(Account accountObject) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("`AccountService` Creating Account....");
    Account account = accountRepository.findByIdAndUserId(userDetails.getUser().getId(), accountObject.getId());
    if(account != null) {
      throw new InformationExistsException("Account Id Already In Use: " + account.getId());
    } else {
      accountObject.setUser(userDetails.getUser()); // set account.user to userID
      return accountRepository.save(accountObject);
    }
  }

  //  account id comes from 'getAccount'
  // passed from `PutMapping` into method as `value`, along with `body`
  public Account updateAccount(Long accountId, Account accountObject) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("calling updateAccount method from Service");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    // findById
    if (account == null) {
      throw new InformationNotFoundException("account with id " + accountId + " not found");
    } else {
      account.setName(accountObject.getName());
      account.setBalance(accountObject.getBalance());
      account.setUser(userDetails.getUser());
      return accountRepository.save(account);
    }
  }

  //  Delete Method to delete account by id
  public String deleteAccount(Long accountId) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("calling deleteAccount method from Service");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    if (account == null) {
      throw new InformationNotFoundException("account with id " + accountId + " Not Found... :(");
    } else {
//      **** DeleteById() ****
      accountRepository.deleteById(accountId);
      return "Account ID: " + accountId + " has been successfully deleted.";
    }
  }
  //  *******************   ACCOUNTS COMPLETED   *******************





  // ***************************** TRANSACTIONS *****************************
  // create single transaction and add to account
  public Transaction createAccountTransaction(Long accountId, Transaction transactionObject) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("Calling createAccountTransaction from Service");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    if (account == null) {
      throw new InformationNotFoundException(
          "account with id " + accountId + " does not belong to this user or account does not exist");
    }

  Transaction transaction = transactionRepository.findByIdAndUserId(transactionObject.getId(), userDetails.getUser().getId());
    System.out.println(transaction);
    if (transaction != null) {
      throw new InformationExistsException("transaction with id " + transaction.getId() + " already exists");
    }
    transactionObject.setUser(userDetails.getUser());
    transactionObject.setAccount(account);

    return transactionRepository.save(transactionObject);
  }

  public List<Transaction> getAccountTransactions(Long accountId) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("Getting Transaction List from Service...");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    if (account == null) {
      throw new InformationNotFoundException("Account " + accountId + " Not Found... :(");
    } else {

      return account.getTransactionList();
    }
  }

  public Transaction getAccountTransaction(Long accountId, Long transactionId) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("Getting Account Transaction from Service...");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    if (account == null) {
      throw new InformationNotFoundException("Account with ID " + accountId + " Not Found... :(");
    }
    // find account, then stream to find (filter) transaction by transactionId and grab the first instance.
    Optional<Transaction> transaction = transactionRepository.findByAccountId(accountId).stream()
            .filter(p-> p.getId().equals(transactionId)).findFirst();
    if (!transaction.isPresent()) {
      throw new InformationNotFoundException("Transaction with ID: " + transactionId + " Not Found... :(");
    }
    return transaction.get();
  }

//  public Transaction updateAccountTransaction(Long accountId, Long transactionId, Transaction transactionObject) {
//    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    LOGGER.info("Updating Transaction from Service...");
//    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
//    if (account == null) {
//      throw new InformationNotFoundException("Account with ID " + accountId + " Not Found... :(");
//    }
//    Optional<Transaction> transaction = transactionRepository.findByAccountId(accountId).stream().filter(p-> p.getId().equals(transactionId)).findFirst();
//      if (!transaction.isPresent()) {
//        throw new InformationNotFoundException("Transaction with ID " + transactionId + " Not Found... :(");
//      }
//      Transaction updateTransaction = transactionRepository.findByBalanceAndUserIdAndIdIsNot(transactionObject.getId(), userDetails.getUser().getId(), transactionId);
//      if (updateTransaction != null) {
//        throw new InformationExistsException("Transaction: " + updateTransaction.getId() + " already exists.");
//      }
//      transaction.get().setId(transactionObject.getId());
//      transaction.get().setBalance(transactionObject.getBalance());
//      transaction.get().setDueDate(transactionObject.getDueDate());
//      return transactionRepository.save(transaction.get());
//  }

  //  Delete Method to delete account by id
//  public void deleteTransaction(Long accountId, Long transactionId) {
//    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//    LOGGER.info("calling deleteAccount method from Service");
//    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
//    if (account == null) {
//      throw new InformationNotFoundException("Account " + accountId + " Not Found... :(");
//    }
//    Optional<Transaction> transaction = transactionRepository.findByAccountId(accountId).stream().filter(p-> p.getId().equals(transactionId)).findFirst();
//    if (!transaction.isPresent()) {
//      throw new InformationNotFoundException("Transaction with ID " + transactionId + " Not Found... :(");
//    }
//    transactionRepository.deleteById(transactionId);
//    LOGGER.info("Transaction: " + transactionId + " Deleted.");
//  }

}