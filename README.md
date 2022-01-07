# Banking API

by H. War, E. Brown, and K. Milligan.

## Technologies

### Platforms
[![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)](https://www.linux.org/)
[![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)](https://www.microsoft.com/)
[![Mac OS](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0)](https://www.apple.com/macos/monterey/)

### IDE
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)

### Language & Frameworks
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
[![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)](https://jwt.io/)

[![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)

[![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)](https://www.markdownguide.org/)
[![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)

### Communications & Support
[![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)](https://slack.com/)
[![Zoom](https://img.shields.io/badge/Zoom-2D8CFF?style=for-the-badge&logo=zoom&logoColor=white)](https://zoom.us/)
[![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)](https://stackoverflow.com/)


## Project Description

We want to build a SECURE (JWT) banking app where a user can create a profile, create an account (type in model), check their balance, deposit money, withdraw money, transfer money to another account (inside user profile), or delete an account from the user profile.




## USER STORIES

- As a customer, I want to create a user profile so I can can set up online banking.
- As a user, I want to Login so I can access my accounts.
- As a user, I want to Logout so that I can keep my information secure(?)
- As a user, I want to Check my Balance so I can know how much money I have.
- As a user, I want to be able to Transfer money between my accounts (?)
- As a user, I want to be able to set up a Checking account, so I can have an account to deposit or withdraw money from.
- As a user, I want to be able to set up a Savings account, so I can save money for later use.
- As a user, I want to Deposit money into my SELECTED account so I can add money to my account.
- As a user, I want to Withdraw money from my account so I can spend it.


## Entity Relationship Diagram 
<div style="display: flex;">

<div style="padding: 15px;">

**Project Start:**
![ERD Image](https://raw.githubusercontent.com/Kieran815/unit-2-project/main/banking%20app.drawio.png "test text")

</div>

<div style="padding: 15px;">

**Project Completion:**
![Unit 2 Banking Api Project Entity Relationship Diagram](Unit2FinalERD.png)

</div>


</div>

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




### Coulda/Shoulda/Might
additional functionality to add... later... sometime.

Add billing
auto withdraw

#### Stretch Goal User Stories:

- As a user, I want to be able to set up an Auto Loan account, so I can pay my car note.
- As a user, I want to be able to set up a Credit Card account, so I can build my credit history.


