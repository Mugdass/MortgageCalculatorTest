package mortgage.tests;

import mortgage.base.BaseTest;
import mortgage.pages.MortgageCalculatorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BoundaryTests extends BaseTest {

    @DataProvider(name = "boundaryInputs")
    public Object[][] boundaryInputs() {
        return new Object[][]{
                {"300000", "0", "30", "3.5"},
                {"300000", "150000", "30", "3.5"}, // 50% down
                {"300000", "60000", "1", "3.5"},   // small term
                {"300000", "60000", "50", "3.5"},  // large term
                {"300000", "60000", "30", "0.1"},  // tiny rate
                {"300000", "60000", "30", "15"}    // large rate
        };
    }

    @Test(dataProvider = "boundaryInputs")
    public void monthlyPaymentStillCalculates(String price, String down, String term, String rate) {
        MortgageCalculatorPage page = new MortgageCalculatorPage(driver)
                .open()
                .setHomePrice(price)
                .setDownPayment(down)
                .setLoanTerm(term)
                .setInterest(rate)
                .calculate();

        String payment = page.getMonthlyPaymentText();
        Assert.assertTrue(payment != null && !payment.isEmpty(), "Expected some output");
    }
}
