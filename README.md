# MortgageCalculatorTest

End-to-end UI tests for a public mortgage calculator site using **Java 17**, **Selenium WebDriver 4**, **TestNG**, and **Maven**, organized with a simple **Page Object Model** and running in **GitHub Actions** CI. Reports are captured via **Allure** artifacts.

## Highlights
- Page Objects (`mortgage.pages.MortgageCalculatorPage`)
- Base test class with **WebDriverManager** and optional **headless** support
- Positive, Negative, and Boundary tests via **DataProviders**
- **testng.xml** suite and **maven-surefire-plugin** config
- CI workflow for Ubuntu + headless Chrome
- Allure result artifacts uploaded automatically

## Requirements
- Java 17+
- Maven 3.8+
- Google Chrome (for local runs). CI installs Chrome automatically.

## Run Locally
```bash
# Headed
mvn clean test

# Headless
mvn -Dheadless=true clean test
```

## View Allure Results Locally
This project produces `allure-results` alongside surefire reports. To generate a local HTML report:
```bash
# Requires Allure commandline installed locally
allure serve target/allure-results
```
Or:
```bash
allure generate target/allure-results -o target/allure-report --clean
```

## Structure
```
src/
  test/java/mortgage/
    base/BaseTest.java
    pages/MortgageCalculatorPage.java
    tests/PositiveTests.java
    tests/NegativeTests.java
    tests/BoundaryTests.java
testng.xml
.github/workflows/maven.yml
```

## CI
The GitHub Actions workflow:
- Checks out the repo
- Sets up Java 17 & Chrome
- Runs tests in headless mode
- Uploads **surefire-reports** and **allure-results** as artifacts
