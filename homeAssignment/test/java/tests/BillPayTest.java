package tests;

import actions.BillPayPageActions;
import actions.OverviewPageActions;
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

        //Make initialization
        OverviewPageActions overviewPage = new OverviewPageActions(driver);
        BillPayPageActions billPayPage = new BillPayPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

        //Get the first account
        String account = overviewPage.getAccount1ID();
        String balance = overviewPage.getAccount1Balance().replace("$","");

        //Navigate to Bill Pay page
        overviewPage.clickBillPayLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Bill Pay"), "Bill Pay page not loaded");


        //Transaction details
        String recipientAccount = "32561";
        String amount = "125.5";

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
        Assert.assertEquals(billPayPage.getSelectFromAccount().getFirst(),account,"Account mismatch");

        //Click Send Payment
        billPayPage.clickSendPayment();

        //Check the payment message
        Assert.assertEquals(billPayPage.getPaymentMessage(),"Bill Payment Complete","Account mismatch");

        //Go to overview page
        billPayPage.clickAccountsOverviewLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Check if the pay was successful
        String currentBalance = overviewPage.getAccount1Balance().replace("$","");
        Assert.assertEquals(Double.parseDouble(currentBalance),
                Double.parseDouble(balance) - Double.parseDouble(amount),
                "Balance inconsistent");


    }
}
