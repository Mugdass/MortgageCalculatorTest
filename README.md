🏡 Mortgage Calculator Test Automation

📖 Project Overview

This project automates the Mortgage Calculator web app using Java, Selenium, TestNG, and the Page Object Model (POM).
It demonstrates:

Clean automation framework structure

Positive, negative, and boundary test scenarios

CI/CD with GitHub Actions

Allure test reporting



🗂 Project Structure

MortgageCalculatorTest
 ┣ 📂 src
 ┃ ┗ 📂 test
 ┃    ┣ 📂 java
 ┃    ┃ ┣ 📂 mortgage.base      # BaseTest (setup/teardown)
 ┃    ┃ ┣ 📂 mortgage.pages     # Page Object (UI interactions)
 ┃    ┃ ┗ 📂 mortgage.tests     # Positive, Negative & Boundary tests
 ┃    ┗ 📂 resources
 ┣ 📄 pom.xml                   # Maven dependencies
 ┣ 📄 testng.xml                # TestNG suite
 ┣ 📄 README.md                 # Project documentation
 ┗ 📂 .github/workflows         # GitHub Actions CI config



 ⚙️ Tech Stack

  Java 17

  Selenium 4 (browser automation)

  TestNG (test framework)

  WebDriverManager (driver management)

  Allure Reports (test reporting)

  GitHub Actions (CI/CD pipeline)




▶️ How to Run Tests

Clone the repo and run with Maven:


# Run in headed mode
mvn clean test

# Run in headless mode (for CI/servers)
mvn clean test -Dheadless=true




📊 Test Coverage

Positive tests – valid mortgage calculations

Negative tests – invalid/missing inputs

Boundary tests – edge cases (0 values, large numbers, etc.)





📈 Continuous Integration

On every push/PR, GitHub Actions:

Runs the Selenium tests in headless mode

Uploads test results (surefire-reports + allure-results) as artifacts
