package mortgage.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if ("true".equalsIgnoreCase(System.getProperty("headless"))) {
            options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        }
        options.addArguments("--window-size=1366,768");
        driver = new ChromeDriver(options);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
