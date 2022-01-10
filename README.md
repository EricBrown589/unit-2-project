[//]: # (# Banking API)

[//]: # ()
[//]: # (by H. War, E. Brown, and K. Milligan.)

[//]: # ()
[//]: # ()
[//]: # ()
[//]: # ()
[//]: # (## Project Description)

[//]: # ()
[//]: # (<!-- PROJECT SHIELDS -->)

[//]: # ()
[//]: # ([![Contributors][contributors-shield]][contributors-url])

[//]: # ()
[//]: # ([![Forks][forks-shield]][forks-url])

[//]: # ()
[//]: # ([![Stargazers][stars-shield]][stars-url])

[//]: # ()
[//]: # ([![Issues][issues-shield]][issues-url])

[//]: # ()
[//]: # ([![MIT License][license-shield]][license-url])

[//]: # ([![LinkedIn][linkedin-shield]][linkedin-url])



<!-- PROJECT LOGO -->
<br />
<div align="center">

[//]: # (  <a href="https://github.com/Kieran815/unit-2-project">)

[//]: # (    <img src="images/logo.png" alt="Logo" width="80" height="80">)

[//]: # (  </a>)

<h1 align="center">Banking API</h1>

  <p align="center">
    project_description
    <br />
    <a href="https://github.com/Kieran815/unit-2-project"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/Kieran815/unit-2-project">View Demo</a>
    ·
    <a href="https://github.com/Kieran815/unit-2-project/issues">Report Bug</a>
    ·
    <a href="https://github.com/Kieran815/unit-2-project/issues">Request Feature</a>
  </p>
</div>



<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#technologies">Technologies</a></li>
        <li><a href="#user-stories">User Stories</a></li>
        <li><a href="#Entity Relationship Diagram">Entity Relationship Diagram</a></li>
        <li><a href="#api-endpoints-and-methods">API Endpoints and Methods</a></li>
        <li><a href="#challenges">Challenges</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#roadmap">Roadmap</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgments">Acknowledgments</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

Banking API was built to help streamline your financial transactions. It has the ability to create and delete accounts, update account descriptions, create transactions that update your account balances, and the ability to pull money from other accounts to prevent over-drafting.

### Technologies
#### Platforms
[![Linux](https://img.shields.io/badge/Linux-FCC624?style=for-the-badge&logo=linux&logoColor=black)](https://www.linux.org/)
[![Windows](https://img.shields.io/badge/Windows-0078D6?style=for-the-badge&logo=windows&logoColor=white)](https://www.microsoft.com/)
[![Mac OS](https://img.shields.io/badge/mac%20os-000000?style=for-the-badge&logo=macos&logoColor=F0F0F0)](https://www.apple.com/macos/monterey/)
#### IDE
[![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
#### Language & Frameworks
[![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
[![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/)
[![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)](https://maven.apache.org/)
[![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)](https://jwt.io/)
[![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)](https://www.postgresql.org/)
[![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)](https://www.postman.com/)
[![Markdown](https://img.shields.io/badge/markdown-%23000000.svg?style=for-the-badge&logo=markdown&logoColor=white)](https://www.markdownguide.org/)
[![Git](https://img.shields.io/badge/git-%23F05033.svg?style=for-the-badge&logo=git&logoColor=white)](https://git-scm.com/)
[![GitHub](https://img.shields.io/badge/github-%23121011.svg?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)
#### Communications & Support
[![Slack](https://img.shields.io/badge/Slack-4A154B?style=for-the-badge&logo=slack&logoColor=white)](https://slack.com/)
[![Zoom](https://img.shields.io/badge/Zoom-2D8CFF?style=for-the-badge&logo=zoom&logoColor=white)](https://zoom.us/)
[![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)](https://stackoverflow.com/)

### USER STORIES

- As a customer, I want to create a user profile so I can can set up online banking.
- As a user, I want to Login so I can access my accounts.
- As a user, I want to Logout so that I can keep my information secure(?)
- As a user, I want to Check my Balance so I can know how much money I have.
- As a user, I want to be able to Transfer money between my accounts (?)
- As a user, I want to be able to set up a Checking account, so I can have an account to deposit or withdraw money from.
- As a user, I want to be able to set up a Savings account, so I can save money for later use.
- As a user, I want to Deposit money into my SELECTED account so I can add money to my account.
- As a user, I want to Withdraw money from my account so I can spend it.


### Entity Relationship Diagram
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

### API Endpoints and Methods

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

### Challenges
.gitignore issues

<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
### Getting Started

This Program requires Java11, Spring, Maven,

#### Prerequisites

This is an example of how to list things you need to use the software and how to install them.
* npm
  ```sh
  npm install npm@latest -g
  ```

#### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Kieran815/unit-2-project.git
   ```
2. Install NPM packages
   ```sh
   npm install
   ```
3. Enter your API in `config.js`
   ```js
   const API_KEY = 'ENTER YOUR API';
   ```

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
### Usage

Please Review our _[Postman Documentation](https://documenter.getpostman.com/view/13909137/UVXeqxVH)_ for a complete list of Language Agnostic endpoint interactions.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- ROADMAP -->
### Roadmap

- [] User Login w/ JWT
  - [] Access to user accounts
      - [] Create Rolling Transactions based on value and balances.

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- CONTRIBUTING -->
### Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#top">back to top</a>)</p>

### Coulda/Shoulda/Might
additional functionality to add... later... sometime.

Add billing
auto withdraw

#### Stretch Goal User Stories:

- As a user, I want to be able to set up an Auto Loan account, so I can pay my car note.
- As a user, I want to be able to set up a Credit Card account, so I can build my credit history.

<!-- LICENSE -->
## License

Distributed under the MIT License.

<p align="right">(<a href="#top">back to top</a>)</p>


## Contact

Kieran Milligan - [@NoLivesMatter42](https://twitter.com/NoLivesMatter42) - kieran.milligan@gmail.com

Habsatou War - [@hwarba](https://twitter.com/hwarba) - hwar@cincinnatistate.edu

Eric Brown - [@KiltedTyger]() - ericbrown589@yahoo.com

Project Link: [https://github.com/Kieran815/unit-2-project](https://github.com/Kieran815/unit-2-project)

<p align="right">(<a href="#top">back to top</a>)</p>


## Acknowledgments

* [Suresh Melvin Sigera](https://www.linkedin.com/in/sureshmelvinsigera/)
* [David Magbee](https://www.linkedin.com/in/davidmagbee/)
* [Usman Basir](https://www.linkedin.com/in/usmanbashir/)

<p align="right">(<a href="#top">back to top</a>)</p>