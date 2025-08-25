package mortgage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MortgageCalculatorTests {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

        
        driver = new ChromeDriver();

        
        driver.get("https://www.calculator.net/mortgage-calculator.html");
        driver.manage().window().maximize();
    }

    @Test
    public void testValidCalculation() {
        WebElement homePrice = driver.findElement(By.id("homeval"));
        homePrice.clear();
        homePrice.sendKeys("300000");

        WebElement downPayment = driver.findElement(By.id("downpayment"));
        downPayment.clear();
        downPayment.sendKeys("60000");

        WebElement loanTerm = driver.findElement(By.id("loanterm"));
        loanTerm.clear();
        loanTerm.sendKeys("30");

        WebElement interest = driver.findElement(By.id("intrstsrate"));
        interest.clear();
        interest.sendKeys("3.5");

        WebElement calcBtn = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calcBtn.click();

        WebElement monthlyPayment = driver.findElement(By.xpath("//h3[contains(text(),'Monthly Payment')]/following-sibling::div/b"));
        String result = monthlyPayment.getText();
        System.out.println("Monthly Payment: " + result);
        Assert.assertTrue(result.contains("$1,347"), "Unexpected monthly payment result.");
    }

    @Test
    public void testInvalidLoanAmount() {
        WebElement homePrice = driver.findElement(By.id("homeval"));
        homePrice.clear();
        homePrice.sendKeys("-100000");

        WebElement calcBtn = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calcBtn.click();

        WebElement result = driver.findElement(By.xpath("//h3[contains(text(),'Monthly Payment')]/following-sibling::div/b"));
        String payment = result.getText();
        Assert.assertFalse(payment.contains("$"), "Unexpected valid output for invalid input.");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
