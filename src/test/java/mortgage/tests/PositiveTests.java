package mortgage.tests;

import mortgage.base.BaseTest;
import mortgage.pages.MortgageCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositiveTests extends BaseTest {

    @DataProvider(name = "validInputs")
    public Object[][] validInputs() {
        return new Object[][]{
                {"300000", "60000", "30", "3.5"},
                {"450000", "90000", "15", "2.9"},
                {"200000", "40000", "20", "4.2"}
        };
    }

    @Test(dataProvider = "validInputs")
    public void monthlyPaymentIsShown(String price, String down, String term, String rate) {
        MortgageCalculatorPage page = new MortgageCalculatorPage(driver)
                .open()
                .setHomePrice(price)
                .setDownPayment(down)
                .setLoanTerm(term)
                .setInterest(rate)
                .calculate();

        String payment = page.getMonthlyPaymentText();
        Assert.assertTrue(payment != null && payment.trim().length() > 0, "Payment text should not be empty");
        Assert.assertTrue(payment.contains("$") || payment.matches(".*\\d+.*"), "Payment should look like a currency/number");
    }
}
