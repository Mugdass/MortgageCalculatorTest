package mortgage.tests;

import mortgage.base.BaseTest;
import mortgage.pages.MortgageCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NegativeTests extends BaseTest {

    @DataProvider(name = "invalidInputs")
    public Object[][] invalidInputs() {
        return new Object[][]{
                {"abc", "60000", "30", "3.5"},
                {"300000", "xyz", "30", "3.5"},
                {"300000", "60000", "-5", "3.5"},
                {"300000", "60000", "30", "-1"},
                {"", "", "", ""}
        };
    }

    @Test(dataProvider = "invalidInputs")
    public void invalidInputsDoNotProduceCurrency(String price, String down, String term, String rate) {
        MortgageCalculatorPage page = new MortgageCalculatorPage(driver)
                .open()
                .setHomePrice(price)
                .setDownPayment(down)
                .setLoanTerm(term)
                .setInterest(rate)
                .calculate();

        String payment = page.getMonthlyPaymentText();
        Assert.assertFalse(payment.startsWith("$"), "Expected no valid currency output for invalid input");
    }
}
