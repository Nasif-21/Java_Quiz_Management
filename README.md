# Java Quiz Management System

## Overview
This project is a Java-based Quiz Management System that supports two types of users: Admin and Student. The Admin can add and manage questions in a question bank, while Students can log in and take quizzes. Each quiz randomly selects 10 questions from the bank, ensuring a unique experience every time. After submission, the system automatically checks the answers, calculates the score, and shows how many marks the student achieved.

## Description
### User Roles
* The system has two types of users: Admin and Student.
* Each user must log in with their name and password, which are securely stored inside a JSON file.

### Admin Role

* After login verification, the Admin is guided to manage the quiz question bank.
* By pressing ‘s’, the Admin can add a new question along with multiple-choice options and the correct answer.
* Once a question is saved, the Admin is asked whether they want to continue adding more (by pressing ‘s’) or stop (by pressing ‘q’).
* This allows the Admin to build and expand the question bank over time.

### Student Role

* Students log in with verified credentials stored in JSON.
* After login, the system randomly generates 10 questions from the question bank for the quiz.
* This random selection makes each quiz unique, giving students a fresh experience every time.
* Once the quiz is completed, the system automatically checks the answers, calculates the score, and provides feedback on performance.
* A student can attempt a quiz for the first time or retake it again if they wish, giving them the opportunity to improve their performance and practice more.

### Quiz Management

* Both questions and user credentials are stored in JSON format, using key–value pairs for organized indexing and easy retrieval.
* The system ensures randomization, but if the question bank is too small, some questions may repeat within a quiz.
* Marks are given based on the number of correct answers, allowing students to instantly see their results.

## Used Technology 
* Java
* JSON parser
* JSON Array
* JSON object
* JSON file 
* Gradle
* Random method
  
## Demo video
### Play this video to understand full flow of quiz management system
https://github.com/user-attachments/assets/ead6d0a2-fd35-458e-ab35-1ef62e946c4b

