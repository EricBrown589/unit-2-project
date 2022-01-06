package com.banking.bankingapi.service;

import com.banking.bankingapi.exception.InformationExistsException;
import com.banking.bankingapi.exception.InformationNotFoundException;
import com.banking.bankingapi.exception.InsufficientResources;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.model.User;
import com.banking.bankingapi.repository.AccountRepository;
import com.banking.bankingapi.repository.TransactionRepository;
import com.banking.bankingapi.repository.UserRepository;
import com.banking.bankingapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AccountService {

  private AccountRepository accountRepository;
 private TransactionRepository transactionRepository;
 private UserRepository userRepository;


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

  @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
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



    /**
     * <h1>CREATE ACCOUNT</h1>
     * <p>Check if the account is not already in the database</p>
     * <p>Update the totalBalance of the user </p>
     * @param accountObject
     * @return
     */
  public Account createAccount(Account accountObject) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("`AccountService` Creating Account....");
    User user = userDetails.getUser();
    Account account = accountRepository.findByIdAndUserId(userDetails.getUser().getId(), accountObject.getId());
    if(account != null) {
      throw new InformationExistsException("Account Id Already In Use: " + account.getId());
    } else {
      accountObject.setUser(userDetails.getUser()); // set account.user to userID
        //update user balance
        user.setTotalBalance(user.getTotalBalance() + accountObject.getBalance());
        userRepository.save(user);
      return accountRepository.save(accountObject);
    }
  }

    /**
     * <h1> Update Account </h1>
     * passed from `PutMapping` into method as `value`, along with `body`
     * @param accountId
     * @param accountObject
     * @return
     */
  public Account updateAccount(Long accountId, Account accountObject) {
    MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    LOGGER.info("calling updateAccount method from Service");
    Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
    // findById
    if (account == null) {
      throw new InformationNotFoundException("account with id " + accountId + " not found");
    } else {
        // update the user Total Balance
        User user = userDetails.getUser();
        // Take the current account balance from user Total Balance
        user.setTotalBalance(user.getTotalBalance() - account.getBalance());
        // Add the new account balance to user Total Balance
        user.setTotalBalance(user.getTotalBalance() + accountObject.getBalance());
        userRepository.save(user);
      account.setName(accountObject.getName());
//      account.setBalance(accountObject.getBalance());
//      account.setUser(userDetails.getUser());
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
        // update the user Total Balance
        User user = userDetails.getUser();
        // Take the current account balance from user Total Balance
        user.setTotalBalance(user.getTotalBalance() - account.getBalance());
        userRepository.save(user);
      // **** DeleteById() ****
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
    if (transaction != null) {
      throw new InformationExistsException("transaction with id " + transaction.getId() + " already exists");
    }
    // update account balance - check type of trans and amount
    //    get account info;
    //    account.balance()
//    System.out.println(account.getBalance());
<<<<<<< HEAD
    if (transactionObject.getType().toLowerCase().equals("withdraw")) { // check transaction type
        // check if balance less than withdraw
        // Get withdraw
        double withdraw = transactionObject.getAmount();
//        double totalBalance = accountRepository.findAllBalanceById(accountId);

      if(withdraw < account.getBalance()){
=======
      // update the user Total Balance
      User user = userDetails.getUser();

      // Take the current account balance from user Total Balance
      double totalBalance = user.getTotalBalance();
      // Get withdraw or deposit amount
      double transactionAmount = transactionObject.getAmount();
      /*
       *       withdraw
       */
    if (transactionObject.getType().toLowerCase().equals("withdraw")) {

      // check if balance less than withdraw
      if(transactionAmount < account.getBalance()){
>>>>>>> e910f895744b4f9c2674b2fd0d11945700af3837
          account.setBalance(account.getBalance() - transactionObject.getAmount());
          accountRepository.save(account);
          // update the user Total Balance
          // Take the current account balance from user Total Balance
          user.setTotalBalance(user.getTotalBalance() - account.getBalance());
          userRepository.save(user);
      }// check if balance less than all total balance of all accounts
<<<<<<< HEAD
//      else if(withdraw < totalBalance){
//
//          double amountLeftToWithdraw = withdraw - account.getBalance();
//          account.setBalance(0.0);
//          accountRepository.save(account);
//          // check for any other balance
//          // loop in to the other account until all amountLeftToWithdraw reach
//      }
=======
      else if(transactionAmount < totalBalance){

          double amountLeftToWithdraw = transactionAmount - account.getBalance();
          // update the user Total Balance
          // Take the current account balance from user Total Balance
          user.setTotalBalance(user.getTotalBalance() - account.getBalance());
          userRepository.save(user);

          account.setBalance(0.0);
          accountRepository.save(account);
          // check for any other balance
          // loop in to the other account until all amountLeftToWithdraw reach
          List <Account> accounts = user.getAccountList();
          int i =0 ;
          while (amountLeftToWithdraw > 0 && i < accounts.size() ){
              if(accounts.get(i).getBalance() > amountLeftToWithdraw){
                  // update the user Total Balance
                  // Take the current account balance from user Total Balance
                  user.setTotalBalance(user.getTotalBalance() - amountLeftToWithdraw);
                  userRepository.save(user);
                  accounts.get(i).setBalance(accounts.get(i).getBalance() - amountLeftToWithdraw);
                  // save
                  accountRepository.save(accounts.get(i));

                  amountLeftToWithdraw = 0;

              }else {
                  // Take the current account balance from user Total Balance
                  user.setTotalBalance(user.getTotalBalance() - amountLeftToWithdraw);
                  amountLeftToWithdraw = amountLeftToWithdraw - accounts.get(i).getBalance();
                  userRepository.save(user);
                  accounts.get(i).setBalance(0.0);
                  accountRepository.save(accounts.get(i));
              }
              i++;
          }

      }
>>>>>>> e910f895744b4f9c2674b2fd0d11945700af3837
      else{
          throw new InsufficientResources("Balance Insufficient");
      }
        //save new balance to account
    }
      else if (transactionObject.getType().toLowerCase().equals("deposit")) { // check transaction type
          user.setTotalBalance(user.getTotalBalance() + transactionAmount);
          userRepository.save(user);
          account.setBalance(account.getBalance() + transactionObject.getAmount()); // addition transaction amt from account balance
          accountRepository.save(account);
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
    Transaction transaction = transactionRepository.findByIdAndAccountId(transactionId, accountId);
    if (transaction == null) {
      throw new InformationNotFoundException("Transaction with ID: " + transactionId + " Not Found... :(");
    }
    return transaction;
  }

    /**
     * <h1> Update transaction</h1>
     * <p> Use accounId and id of current user to check if it exists</p>
     * <p> Use accounId and transaction id to check if it exists and take the first found</p>
     * <p> Update and save the new description</p>
     * @param accountId
     * @param transactionId
     * @param transactionObject
     * @return
     */
  public Transaction updateAccountTransaction(Long accountId, Long transactionId, Transaction transactionObject) {
      MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
      LOGGER.info("Updating Transaction from Service...");
      Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
      if (account == null) {
          throw new InformationNotFoundException("Account with ID " + accountId + " Not Found... :(");
      }
      Transaction transaction = transactionRepository.findByIdAndAccountId(transactionId, accountId);
      if (transaction == null) {
          throw new InformationNotFoundException("Transaction with ID: " + transactionId + " Not Found... :(");
      }

      Transaction updateTransaction = transactionRepository.findByIdAndUserIdAndAccountId(transactionId, userDetails.getUser().getId(), accountId);
      if (updateTransaction.getDescription().equals(transactionObject.getDescription())) {
        throw new InformationExistsException("Transaction already has this description.");
      }
      transaction.setDescription(transactionObject.getDescription());
      return transactionRepository.save(transaction);
  }

//  User updateTotalBalance(){
//      MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//      LOGGER.info("Updating Transaction from Service...");
//      User user = userDetails.getUser();
//      List <Account> accounts = user.getAccountList();
//      for(int i = 0;)
//      user.setTotalBalance(user.getTotalBalance() - account.getBalance());
//  }
}