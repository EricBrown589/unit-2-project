# Banking App

by H. War, E. Brown, and K. Milligan.

## Project Description

We want to build a SECURE (JWT) banking app where a user can create a profile, create an account (type in model), check
their balance, deposit money, withdraw money, transfer money to another account (inside user profile), or delete an
account from the user profile.

### Stretch

Add billing/ auto withdraw

## USER STORIES

### Primary User Stories:

- As a customer, I want to create a user profile so I can can set up online banking.
- As a user, I want to Login so I can access my accounts.
- As a user, I want to Logout so that I can keep my information secure(?)
- As a user, I want to Check my Balance so I can know how much money I have.
- As a user, I want to be able to Transfer money between my accounts (?)
- As a user, I want to be able to set up a Checking account, so I can have an account to deposit or withdraw money from.
- As a user, I want to be able to set up a Savings account, so I can save money for later use.
- As a user, I want to Deposit money into my SELECTED account so I can add money to my account.
- As a user, I want to Withdraw money from my account so I can spend it.

### Stretch Goal User Stories:

As a user, I want to be able to set up an Autoloan (Stretch) account, so I can pay my car note. As a user, I want to be
able to set up a Credit Card (Stretch) account, so I can build my credit history. Opening Limit: $5000;

credit card make payment view history pay towards balance

![ERD Image](https://raw.githubusercontent.com/Kieran815/unit-2-project/main/banking%20app.drawio.png "test text")

| HTTP Method | Endpoint                                                   | Functionality                                                          | Access  |
|-------------|------------------------------------------------------------|------------------------------------------------------------------------|---------|
| POST        | /auth/users/register                                       | Registers a user                                                       | PUBLIC  |
| POST        | /auth/users/login                                          | Logs a user in                                                         | PUBLIC  |
| GET         | /api/accounts                                              | Lists all Account groups                                               | PRIVATE |
| POST        | /api/accounts                                              | Creates a new Account group                                            | PRIVATE |
| GET         | /api/accounts/{accountsId}                                 | Gets a single Account group with the supplied id                       | PRIVATE |
| PUT         | /api/accounts/{accountsId}                                 | Updates an Account group with the supplied id                          | PRIVATE |
| DELETE      | /api/accounts/{accountsId}                                 | Deletes a account group with the supplied id                           | PRIVATE |
| GET         | /api/accounts/{accountsId}/account                         | List all accounts in the given account group                           | PRIVATE |
| POST        | /api/categories/{accountsId}/account                       | Creates a new account in the given Account group                       | PRIVATE |
| GET         | /api/accounts/{accountsId}/account/{accountId}/transaction | Gets a List of transactions with the supplied accountsId and accountId | PRIVATE |
| PUT         | /api/accounts/{accountsId}/account/{accountId}             | Updates an account in the given account group                          | PRIVATE |
| DELETE      | /api/accounts/{accountsId}/account/{accountId}             | Deletes an account in the given Account group                          | PRIVATE |


    