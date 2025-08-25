# 🏡 Mortgage Calculator Test Automation


## 📖 Project Overview
This project automates the **Mortgage Calculator** web application using **Java, Selenium, TestNG, and Page Object Model (POM)**.  

It demonstrates:
- Scalable automation framework design  
- Positive, negative, and boundary test coverage  
- Page Object Model (POM) for reusability and maintainability  
- CI/CD with GitHub Actions (runs tests on every push/PR)  
- Allure reporting integration  

---

## 🗂 Project Structure


MortgageCalculatorTest/
┣ 📂 src/test/java/mortgage
┃ ┣ 📂 base # Base setup/teardown (WebDriver)
┃ ┣ 📂 pages # Page Object Model classes
┃ ┗ 📂 tests # Positive, Negative, Boundary tests
┣ 📄 pom.xml # Maven dependencies
┣ 📄 testng.xml # TestNG suite configuration
┣ 📄 .gitignore # Clean repo (no target/, no drivers)
┣ 📄 README.md # Project documentation
┗ 📂 .github/workflows
┗ maven.yml # GitHub Actions CI workflow





---

## ⚙️ Tech Stack
- **Java 17**  
- **Selenium 4** (browser automation)  
- **TestNG** (test framework)  
- **WebDriverManager** (driver handling)  
- **Allure Reports** (reporting)  
- **Maven** (dependency management)  
- **GitHub Actions** (CI/CD pipeline)  

---



## ⚙️ Tech Stack
- **Java 17**  
- **Selenium 4** (browser automation)  
- **TestNG** (test framework)  
- **WebDriverManager** (driver handling)  
- **Allure Reports** (reporting)  
- **Maven** (dependency management)  
- **GitHub Actions** (CI/CD pipeline)  

---

## ▶️ How to Run Tests
Clone the repo and run with Maven:

```bash
# Run in headed mode
mvn clean test

# Run in headless mode (for CI/servers)
mvn clean test -Dheadless=true

---


## 📊 Test Coverage

✅ Positive tests – valid mortgage calculations

❌ Negative tests – invalid or missing input handling

⚖️ Boundary tests – edge cases (0 values, large numbers, unusual rates)


---


## 📈 Continuous Integration

 On every push/PR, GitHub Actions:

 Sets up JDK 17 & Maven

 Runs Selenium tests in headless mode

 Uploads test results (Surefire + Allure) as artifacts


---
