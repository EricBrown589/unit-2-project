package com.banking.bankingapi.service;

import com.banking.bankingapi.exception.InformationExistsException;
import com.banking.bankingapi.exception.InformationNotFoundException;
import com.banking.bankingapi.exception.InsufficientResources;
import com.banking.bankingapi.model.Account;
import com.banking.bankingapi.model.Transaction;
import com.banking.bankingapi.model.User;
import com.banking.bankingapi.repository.AccountRepository;
import com.banking.bankingapi.repository.TransactionRepository;
import com.banking.bankingapi.security.MyUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    private AccountRepository accountRepository;
    private TransactionRepository transactionRepository;

    private static final Logger LOGGER = Logger.getLogger(AccountService.class.getName());

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Autowired
    public void setTransactionRepository(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    //  *** GET SPECIFIC ACCOUNT BY ID
    /**
     *
     * @param accountId
     * @return
     */
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
    /**
     *
     * @return
     */
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

    // CREATE NEW ACCOUNT
    /**
     * <h1>CREATE ACCOUNT</h1>
     * <p>Check if the account is not already in the database</p>
     * <p>Update the totalBalance of the user </p>
     *
     * @param accountObject
     * @return
     */
    public Account createAccount(Account accountObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("`AccountService` Creating Account....");
        User user = userDetails.getUser();
        Account account = accountRepository.findByIdAndUserId(userDetails.getUser().getId(), accountObject.getId());
        if (account != null) {
            throw new InformationExistsException("Account Id Already In Use: " + account.getId());
        } else {
            accountObject.setUser(userDetails.getUser()); // set account.user to userID
            return accountRepository.save(accountObject);
        }
    }

    // Update Account NAME ONLY
    /**
     * <h1> Update Account </h1>
     * passed from `PutMapping` into method as `value`, along with `body`
     *
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
            account.setName(accountObject.getName());
            return accountRepository.save(account);
        }
    }

    //  Delete account by id
    /**
     *
     * @param accountId
     * @return
     */
    public String deleteAccount(Long accountId) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("calling deleteAccount method from Service");
        Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
        if (account == null) {
            throw new InformationNotFoundException("account with id " + accountId + " Not Found... :(");
        } else {
            User user = userDetails.getUser();
            // **** DeleteById() ****
            accountRepository.deleteById(accountId);
            return "Account ID: " + accountId + " has been successfully deleted.";
        }
    }

    // Create Transaction
    /**
     * <h1>create single transaction and add to account</h1>
     * @param accountId
     * @param transactionObject
     * @return
     */
    public Transaction createAccountTransaction(Long accountId, Transaction transactionObject) {
        MyUserDetails userDetails = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        LOGGER.info("Calling createAccountTransaction from Service");
        Account account = accountRepository.findByIdAndUserId(accountId, userDetails.getUser().getId());
        if (account == null) {
            throw new InformationNotFoundException("account with id " + accountId + " does not belong to this user or account does not exist");
        }
        User user = userDetails.getUser();
        List<Account> accounts = user.getAccountList();
        double total = accounts.stream().map(x -> x.getBalance()).reduce((x, y) -> x + y).get();
        System.out.println("******************* Total Account Balance Is " + total + "*******************");
        Transaction transaction = transactionRepository.findByIdAndUserId(transactionObject.getId(), userDetails.getUser().getId());
        if (transaction != null) {
            throw new InformationExistsException("transaction with id " + transaction.getId() + " already exists");
        }
        double transactionAmount = transactionObject.getAmount(); // Get withdraw or deposit amount
        if (transactionObject.getType().toLowerCase().equals("withdraw")) {
            if (transactionAmount < account.getBalance()) { // check if balance less than withdraw
                account.setBalance(account.getBalance() - transactionObject.getAmount());
                accountRepository.save(account);
            } else if (transactionAmount < total) { // check if balance less than all total balance of all accounts
                double amountLeftToWithdraw = transactionAmount - account.getBalance();
                account.setBalance(0.0);
                accountRepository.save(account);
                int i = 0;
                while (amountLeftToWithdraw > 0 && i < accounts.size()) {
                    if (accounts.get(i).getBalance() > amountLeftToWithdraw) {
                        accounts.get(i).setBalance(accounts.get(i).getBalance() - amountLeftToWithdraw);
                        accountRepository.save(accounts.get(i));
                        amountLeftToWithdraw = 0;
                    } else {
                        // Take the current account balance from user Total Balance
                        amountLeftToWithdraw = amountLeftToWithdraw - accounts.get(i).getBalance();
                        accounts.get(i).setBalance(0.0);
                        accountRepository.save(accounts.get(i));
                    }
                    i++;
                }
            } else {
                throw new InsufficientResources("Balance Insufficient");
            }
        } else if (transactionObject.getType().toLowerCase().equals("deposit")) { // check transaction type
            account.setBalance(account.getBalance() + transactionObject.getAmount()); // addition transaction amt from account balance
            accountRepository.save(account);
        } else {
            throw new InsufficientResources("Transaction must be `withdraw` or `deposit`. Transaction NOT Processed. Please Try Again.");
        }
        transactionObject.setUser(userDetails.getUser());
        transactionObject.setAccount(account);
        return transactionRepository.save(transactionObject);
    }

    // Get All Transactions Posted to Account
    /**
     *
     * @param accountId
     * @return
     */
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

    // Get Transaction By Id
    /**
     *
     * @param accountId
     * @param transactionId
     * @return
     */
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

    // Update Transaction DESCRIPTION ONLY
    /**
     * <h1> Update transaction</h1>
     * <p> Use accounId and id of current user to check if it exists</p>
     * <p> Use accounId and transaction id to check if it exists and take the first found</p>
     * <p> Update and save the new description</p>
     *
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
}