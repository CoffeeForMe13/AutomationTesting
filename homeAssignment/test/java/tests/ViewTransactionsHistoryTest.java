package tests;

import actions.AccountActivityPageActions;
import actions.OverviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.LoginTest.login;

public class ViewTransactionsHistoryTest extends BaseTestFunctionality {


    @Test
    public void viewTransactionsHistoryTest(){

        //Create test
        initTest("View transaction history");

        //Make initialization
        OverviewPageActions overviewPage = new OverviewPageActions(driver);
        AccountActivityPageActions accountActivityPage = new AccountActivityPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Get the account details
        String account1ID = overviewPage.getAccount1ID();
        String account1Balance = overviewPage.getAccount1Balance();

        //Open account info dor the first account
        overviewPage.clickAccount1ID();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Account Activity"), "Account Activity page not loaded");


        //Check account details
        System.out.println(accountActivityPage.getAccountID());
        Assert.assertEquals(accountActivityPage.getAccountID(),
                account1ID,
                "Account mismatch");
        System.out.println(accountActivityPage.getAccountType());
        Assert.assertEquals(accountActivityPage.getAccountType(),
                "CHECKING",
                "Account type mismatch");
        System.out.println(accountActivityPage.getAccountBalance());
        Assert.assertEquals(accountActivityPage.getAccountBalance(),
                account1Balance,
                "Account balance mismatch");
        System.out.println(accountActivityPage.getAccountAvailableBalance());
        if(accountActivityPage.getAccountBalance().contains("-")){
            Assert.assertEquals(accountActivityPage.getAccountAvailableBalance(),
                    "$0.00",
                    "Account available balance mismatch");
        } else {
            Assert.assertEquals(accountActivityPage.getAccountAvailableBalance(),
                    accountActivityPage.getAccountBalance(),
                    "Account available balance mismatch");
        }



        //Check account transactions
        List<String> transactions = accountActivityPage.getTableRowsToList();
//        accountActivityPage.checkInitialFoundsTransfer();
//        accountActivityPage.checkFoundsTransfer();
//        accountActivityPage.checkBillPayment();
        //Funds Transfer Sent $100.00
        //Bill Payment to Mircea Grad $125.50
        boolean containsInitialTransaction = false;
        boolean containsFoundsTransfer = false;
        boolean containsBillPayment = false;

        for (String transaction : transactions) {
            if (transaction.contains("Funds Transfer Sent $100.00") && containsInitialTransaction){
                containsFoundsTransfer = true;
            }
            if (transaction.contains("Funds Transfer Sent $100.00")){
                containsInitialTransaction = true;
            }
            if (transaction.contains("Bill Payment to " + configLoader.getProperty("firstName") + " " + configLoader.getProperty("lastName") + " " + "$125.50")){
                containsBillPayment = true;
            }
        }

        System.out.println("Initial transaction found - " + containsInitialTransaction);
        Assert.assertTrue(containsInitialTransaction,"Initial transaction not found");
        System.out.println("Funds Transfer found - " + containsFoundsTransfer);
        Assert.assertTrue(containsFoundsTransfer,"Funds Transfer not found");
        System.out.println("Bill Payment found - " + containsBillPayment);
        Assert.assertTrue(containsBillPayment,"Bill Payment not found");
    }
}
