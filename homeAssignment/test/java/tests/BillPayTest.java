package tests;

import actions.BillPayPageActions;
import actions.OverviewPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.LoginTest.login;

public class BillPayTest extends BaseTestFunctionality {

    @Test
    public void payBillTest(){

        //Create test
        initTest("Pay Bill");

//        //Make initialization
//        OverviewPageActions overviewPage = new OverviewPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

        //Get the first account
        String account = overviewPage.getAccountList().getFirst();
        String balance = overviewPage.getBalanceList().getFirst().replace("$","");



        //Transaction details
        String recipientAccount = "32561";
        String amount = "125.5";

        makePayment(overviewPage, driver, configLoader, recipientAccount, amount, account);

        //Check if the pay was successful
        String currentBalance = overviewPage.getBalanceList().getFirst().replace("$","");
        Assert.assertEquals(Double.parseDouble(currentBalance),
                Double.parseDouble(balance) - Double.parseDouble(amount),
                "Balance inconsistent");


    }

    public static void makePayment(OverviewPageActions overviewPage, WebDriver driver, ConfigurationLoader configLoader, String recipientAccount, String amount, String account) {

        //Make initialization
        BillPayPageActions billPayPage = new BillPayPageActions(driver);

        //Navigate to Bill Pay page
        overviewPage.clickBillPayLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Bill Pay"), "Bill Pay page not loaded");

        //Enter bill data
        billPayPage.enterPayeeName(configLoader.getProperty("firstName") + " " + configLoader.getProperty("lastName"));
        billPayPage.enterAddress(configLoader.getProperty("address"));
        billPayPage.enterCity(configLoader.getProperty("city"));
        billPayPage.enterState(configLoader.getProperty("state"));
        billPayPage.enterZipCode(configLoader.getProperty("zipCode"));
        billPayPage.enterPhoneNumber(configLoader.getProperty("phoneNumber"));
        billPayPage.enterAccount(recipientAccount);
        billPayPage.enterVerifyAccount(recipientAccount);
        billPayPage.enterAmount(amount);
        billPayPage.selectFromAccount(account);

        //Check the selected From Account option
        Assert.assertEquals(billPayPage.getSelectFromAccount().size(),1,"Too many options selected");
        Assert.assertEquals(billPayPage.getSelectFromAccount().getFirst(), account,"Account mismatch");

        //Click Send Payment
        billPayPage.clickSendPayment();

        //Check the payment message
        Assert.assertEquals(billPayPage.getPaymentMessage(),"Bill Payment Complete","Account mismatch");

        //Go to overview page
        billPayPage.clickAccountsOverviewLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

    }
}
