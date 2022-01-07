# Banking API

by H. War, E. Brown, and K. Milligan.

![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)
![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)
![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)
![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)
![Zoom](https://img.shields.io/badge/Zoom-2D8CFF?style=for-the-badge&logo=zoom&logoColor=white)
![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)


## Project Description

We want to build a SECURE (JWT) banking app where a user can create a profile, create an account (type in model), check their balance, deposit money, withdraw money, transfer money to another account (inside user profile), or delete an account from the user profile.

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

## Entity Relationship Diagram 

**Project Start:**
![ERD Image](https://raw.githubusercontent.com/Kieran815/unit-2-project/main/banking%20app.drawio.png "test text")

**Project Completion:**
![Unit 2 Banking Api Project Entity Relationship Diagram](Unit2FinalERD.png)


## API Endpoints and Methods

[***PostMan Request Documentation***](https://documenter.getpostman.com/view/13909137/UVXeqxVH)

| HTTP Method | Endpoint                                             | Functionality                                                             | Access  |
|-------------|------------------------------------------------------|---------------------------------------------------------------------------|---------|
| POST        | /auth/users/register                                 | Registers a user                                                          | PUBLIC  |
| POST        | /auth/users/login                                    | Logs a user in                                                            | PUBLIC  |
| GET         | /api/account                                         | Lists all Account groups                                                  | PRIVATE |
| POST        | /api/account                                         | Creates a new Account group                                               | PRIVATE |
| GET         | /api/account/{accountId}                             | Gets a single Account group with the supplied id                          | PRIVATE |
| PUT         | /api/account/{accountId}                             | Updates an Account group with the supplied id                             | PRIVATE |
| DELETE      | /api/account/{accountId}                             | Deletes a account group with the supplied id                              | PRIVATE |
| GET         | /api/account/{accountId}/transaction                 | List all transactions in the given account                                | PRIVATE |
| POST        | /api/account/{accountId}/transaction                 | Creates a new transaction in the given Account                            | PRIVATE |
| GET         | /api/account/{accountId}/transaction/{transactionId} | Gets a List of transactions with the supplied accountId and transactionId | PRIVATE |
| PUT         | /api/account/{accountId}/transaction/{transactionId} | Updates a transaction in the given account                                | PRIVATE |


