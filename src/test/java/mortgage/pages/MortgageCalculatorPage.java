package mortgage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MortgageCalculatorPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators (for https://www.mortgagecalculator.org/)
    private final By homePrice = By.id("homeval");
    private final By downPayment = By.id("downpayment");
    private final By loanTerm = By.id("loanterm");
    private final By interest = By.id("intrstsrate");
    private final By calcBtn = By.xpath("//input[@value='Calculate']");
    private final By monthlyPayment = By.xpath("//h3[contains(text(),'Monthly Payment')]/following-sibling::div/b");

    public MortgageCalculatorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public MortgageCalculatorPage open() {
        driver.get("https://www.mortgagecalculator.org/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePrice));
        return this;
    }

    public MortgageCalculatorPage setHomePrice(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(homePrice));
        el.clear();
        el.sendKeys(value);
        return this;
    }

    public MortgageCalculatorPage setDownPayment(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(downPayment));
        el.clear();
        el.sendKeys(value);
        return this;
    }

    public MortgageCalculatorPage setLoanTerm(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(loanTerm));
        el.clear();
        el.sendKeys(value);
        return this;
    }

    public MortgageCalculatorPage setInterest(String value) {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(interest));
        el.clear();
        el.sendKeys(value);
        return this;
    }

    public MortgageCalculatorPage calculate() {
        wait.until(ExpectedConditions.elementToBeClickable(calcBtn)).click();
        return this;
    }

    public String getMonthlyPaymentText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(monthlyPayment)).getText();
    }
}
