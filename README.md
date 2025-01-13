# Bookstore API Automation Project

This project automates API testing for a **Bookstore API**. It includes scenarios for managing user accounts, including account creation, authentication, authorization, retrieving account details, and deleting accounts. The tests follow **Behavior-Driven Development (BDD)** using **Cucumber** and **TestNG** for test execution, and **Allure** for generating detailed test reports. Docker and Jenkins are utilized for containerization and Continuous Integration (CI), streamlining the testing process and ensuring consistency across environments.

## Table of Contents

- [Features](#features)
- [Test Cases](#test-cases)
    - [User Account Management](#user-account-management)
- [Libraries and Technologies Used](#libraries-and-technologies-used)
- [Project Setup](#project-setup)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Tests Locally](#running-the-tests-locally)
    - [Generating the Allure Report](#generating-the-allure-report)
    - [Running Tests in Docker](#Running-Tests-in-Docker)
- [Conclusion](#conclusion)

## Features

- **API Automation**: Automates API interactions for managing user accounts in the Bookstore, including creation, authentication, authorization, retrieval, and deletion of accounts.
- **Behavior-Driven Development (BDD)**: Implements **BDD** using Cucumber scenarios to define and execute tests in a readable and understandable format, ensuring clear communication of requirements and expected behavior.
- **Service-Based Design Pattern**: Implements a **Service-Based Design Pattern** to define and execute tests in a readable and understandable format.
- **Test Reporting**: Generates detailed test reports using **Allure**, offering a clear overview of test results and execution status.
- **Containerization**: The project is containerized using Docker for consistent testing environments.
- **Continuous Integration (CI)**: Automated tests are integrated with Jenkins, enabling continuous testing and seamless integration into the development pipeline.

## Test Cases

#### Test Case Name: **User Account Management**

**Scenario**: Create, Authenticate, Authorize, Retrieve, and Delete User Account

1. **Step**: User creates a new account
    - **Action**: The user provides valid details to create a new account.
    - **Expectation**: The account should be successfully created with a non-null userId.
    - **Status Code**: 201

2. **Step**: User generates an authentication key
    - **Action**: The user submits their details to generate an authentication key.
    - **Expectation**: The response status should be "Success".
    - **Status Code**: 200

3. **Step**: User authorizes with the authentication key
    - **Action**: The user includes the authentication key in the request body for authorization.
    - **Expectation**: The user should receive a response body of "true".
    - **Status Code**: 200

4. **Step**: User retrieves account details
    - **Action**: The user submits the unique userId to retrieve account details.
    - **Expectation**: The system should return the user's complete information containing the same userId and userName.
    - **Status Code**: 200

5. **Step**: User deletes the account
    - **Action**: The user provides the unique userId to delete the account.
    - **Expectation**: The status code should be 204 (This demo api does not support of deleting account).

## Libraries and Technologies Used

- **Rest-Assured**: Used for API testing, enabling easy and effective interaction with the Bookstore API for validation of responses.
- **Maven**: Manages project dependencies, builds the project, and handles the lifecycle of tests. It also ensures proper versioning and dependency management for tools used.
- **TestNG**: Organizes tests, provides annotations, and structures the test suite. It's used for executing the test scenarios defined in the feature files, ensuring systematic test execution.
- **Cucumber**: Provides a behavior-driven development (BDD) approach for writing tests in Gherkin syntax. It integrates with TestNG, allowing for clear and readable test scenarios that align with business requirements.
- **Gherkin**: A language used for defining test scenarios in Cucumber. It enables writing tests in a natural language format, ensuring that test cases are easy to understand by both technical and non-technical stakeholders.
- **Gson**: For serializing Java objects to JSON format and deserializing JSON responses, helping with managing data used in tests, especially for API-based validations.
- **Lombok**: Used for reducing boilerplate code such as getters, setters, and constructors, mainly in model classes related to city searches and recent location features.
- **Allure**: For generating detailed and interactive test reports. It provides insights into test execution, including logs and results, helping track the status of each test case.
- **Docker**: Ensures that the project is containerized for consistent environments, allowing seamless test execution across different machines and systems.
- **Jenkins**: Automates the test execution process by integrating tests into a Continuous Integration (CI) pipeline. It triggers test execution on every code change, ensuring consistent quality checks.

## Project Setup

### Prerequisites

1. **Java**: Ensure that Java is installed on your system.
2. **Maven**: For managing project dependencies and building the project.
3. **Allure**: Install Allure Commandline to generate detailed and interactive test reports.
4. **Cucumber & Gherkin**: Ensure that Cucumber and Gherkin are set up to write and execute BDD-based test scenarios.
5. **Docker**: Install Docker to containerize the project and run tests in a consistent and controlled environment.
6. **Jenkins**: A Jenkins server to trigger automated test runs as part of the Continuous Integration (CI) pipeline.
7. **IDE (Optional)**: An Integrated Development Environment (IDE) like IntelliJ IDEA or Eclipse for development and managing project files.

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/sojib96/BookStore_API_Automation.git
    cd Bookstore_API_Automation
    ```

2. Open the project in your preferred IDE.

### Running the Tests Locally

1. Clean the project using Maven:

    ```bash
    mvn clean
    ```

2. Run the tests using Maven:

    ```bash
    mvn test
    ```

### Generating the Allure Report

#### For Temporary Viewing (This will generate and open the Allure report in your browser for quick viewing)
1. Navigate to the `target` directory:
    ```bash
    cd target
    ```

2. Serve the Allure report temporarily:
    ```bash
    allure serve
    ```

#### For Sharing with Others (This will create a HTML file for viewing and sharing)
1. Generate the Allure report as a single file:
    ```bash
    allure generate target/allure-results --single-file
    ```

2. Open the generated report:
    ```bash
    allure open
    ```
### Running Tests in Docker

1. Build the Docker image with the following command:

    ```bash
    docker build -t bookstore_api_automation .
    ```

2. Run the container in interactive mode, mapping port 9090 (or another port of your choice):

    ```bash
    docker run -it -p 9090:9090 --name bookstore_api_automation_container bookstore_api_automation bash
    ```

3. This above command will open a Bash shell inside the Docker container. Once inside the container, clean and run the tests using Maven:

    ```bash
    mvn clean test
    ```

4. After the tests have completed, navigate to the `target` directory:

    ```bash
    cd target
    ```
   Then, serve the Allure report:

    ```bash
    allure serve --port 9090
    ```

5. Open `http://localhost:9090` in your web browser to view the Allure report.

## Conclusion

This project automates API testing for the Bookstore API using **Rest-Assured**, **Cucumber** with **Gherkin**, and **Allure** for reporting. It leverages **Docker** for consistent test environments and **Data-Driven Testing** for flexibility, ensuring reliable test execution and detailed reporting.
