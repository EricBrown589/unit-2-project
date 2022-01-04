# Unit 2 Project

- DO NOT FORK THIS REPO
- [CREATE A NEW REPOSITORY](https://github.com/), AND NAME IT AS unit-2-project
- [SUBMIT A PULL REQUEST WITH THE REPO URL](https://git.generalassemb.ly/java-interapt-11-8/project-2/pulls)

## Description

It's time to put everything you've learned about Java, OOP and Spring into practice!

For this project, you'll build a monolithic back-end using Spring Boot and its modules. You'll use PostgreSQL to create
your database and Tomcat to run your application.

You will be working **with a partner** for this project.

## Technical Requirements

Students' apps must:

### Option1

- Persist at least **four models**.
- Use Spring Profiles for environment settings.
- At least one API endpoint must perform full CRUD **create, read, update, and delete actions**.
- Other API endpoints can perform CRUD based on the business use-case.
- Expose CRUD routes that were built using **REST conventions**.
- **Handle exceptions** gracefully.
- Send appropriate messages back to the client in the event that an exception occurs.
- Must have `Controller` and  `Service` separate.
- Document each end-point, such that

| Request Type | URL| Request Body | |--|--|--| | GET | /api/categories/ | None |

- Stick with the **KISS** (keep it simple, stupid) and **DRY** (don't repeat yourself) principles.

### Option2

- Persist at least **three models**.
- At least one API endpoint must perform full CRUD **create, read, update, and delete actions**.
- Other API endpoints can perform CRUD based on the business use-case.
- Use Spring Profiles for environment settings.
- Use  **JSON Web Tokens** in Spring Security to power user authentication.
- **Protect the routes** with JWT, except for user sign-up and login.
- Expose APIs to perform **user login and sign-up**.
- Expose APIs to perform **create, read, update, and delete actions** .
- **Handle exceptions** gracefully.
- Send appropriate messages back to the client in the event that an exception occurs.
- Must have `Controller` and  `Service` separate.
- Document each end-point

| Request Type | URL| Request Body | Request Header | |--|--|--|--| | GET | /api/categories/ | None | Authorization
Bearer TOKEN

- Stick with the **KISS** (keep it simple, stupid) and **DRY** (don't repeat yourself) principles.

### Bonus Ideas

- Expose an API to update their own user profile.
- Add more unit tests.
- Implement integration tests.
- Allow a user to update their password.
- Allow a user to add a comment within another comment.

## Necessary Deliverables

- A Git repository hosted on GitHub.
- Around 70 commits (or more) on GitHub, dating back to the very beginning of the project. (Commit early, commit often.
  Tell a story with your commits. Each message should give a clear idea of what you changed.)
- A `README.md` file with:
    - Explanations of the machineries used.
    - A couple of paragraphs about the general approach you took.
    - Descriptions of any unsolved problems or major hurdles you had to overcome.
    - A link to your planning documentation for how you broke down this project with deliverables and timelines.
    - Installation instructions for any dependencies.
    - A link to your user stories, ERD diagrams — who are your users, what do they want, and why?

## Submission

**_DO NOT FORK THIS REPOSITORY!_** Create a **new** repository on your personal GitHub account. Then, submit your
project as an issue to this repo:

👉 [Submit Issue Here](https://git.generalassemb.ly/java-interapt-11-8/project-2/issues)

You must turn in something before presentations begin. However, you're welcome to continue working on it over the course
of SEI and beyond!

With your submission please include any questions you'd like answered, or specific things on which you'd like us to
focus when giving feedback.

## Asking For Help - GitHub Issues

GitHub issues are the most useful method for answering technical questions. Issues should follow this format:

```
I tried ___.
I expected ___ to happen.
___ happened instead.
My repo link is ___ and my question is about lines ___.
```

[Just click this handy link to create an issue with these blanks inserted for you!](https://git.generalassemb.ly/java-interapt-11-8/project-2/issues/new?title=issue+with+____&body=I+tried+_____.+I+expected+_____+to+happen._____+happened+instead.%0DMy+repo+link+is+___+and+my+question+is+about+lines+___.)
*Please close your issues when you've received a satisfactory answer*, and let us know what the solution was! We'll
close issues that have gone more than 30 minutes without any updates.
**Note:** Issues can only be reopened by instructors. Therefore, should your issue get closed, please create a *new*
issue, and if it's applicable to your previous issue, just include a link to the previous issue.

**Please `@here Submitted issue #1` in the main Slack channel when you've submitted an issue to give everyone a heads
up.**

## Useful Resources

- [JAVA API](https://docs.oracle.com/en/java/javase/11/docs/api/)
- [ERD Tool](https://www.lucidchart.com/)

## Presentations

We expect everyone to attend all presentations in their entirety and will provide breaks between each session.

This means **no working on your code** while others are presenting. This is your chance to ask others how they tackled
their project.

You'll have 15 minutes each for your presentation. Here are some suggested talking points:

- What would you do differently?
- What are you most proud of?
- What would you do next?
- How did you plan your project?
- What did you learn?
- Q & A

## Plagiarism

Take a moment to re-familiarize yourself with the plagiarism policy, specifically on using work you find online and on
work you do with other students.

We give assignments like this to give you the opportunity to review the material in class in a practical manner. By
building something using what you've learned in class, you'll be reviewing the material and gaining a deeper
understanding of it.

These assignments are similar to those you can expect when applying for a job, either in the form of a take-home coding
challenge or an in-person technical interview. So it's important that you put in your best effort now and challenge
yourself to do this assignment on your own.

If you are struggling with the material, that's alright! That's why you're here. First, try reviewing the previous
lessons and exercises. Go easy on yourself, you're still learning!

Don't copy and paste from another source or another student or the solution branch. That's just going to put you at a
disadvantage when you're interviewing for a job.
