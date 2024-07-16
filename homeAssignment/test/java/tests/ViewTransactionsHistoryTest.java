package tests;

import actions.AccountActivityPageActions;
import actions.OpenNewAccountPageActions;
import actions.OverviewPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.BillPayTest.makePayment;
import static tests.LoginTest.login;
import static tests.OpenNewAccountTest.getNewAccount;
import static tests.TransferFundsTest.transferFunds;

public class ViewTransactionsHistoryTest extends BaseTestFunctionality {


    @Test
    public void viewTransactionsHistoryTest(){

        //Create test
        initTest("View transaction history");

        //Make initialization
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Get the account details of the first account
        String account1ID = overviewPage.getAccountList().getFirst();



        //Open new account
        String newAccount = getNewAccount(overviewPage, openNewAccountPage, driver);

        //Declare transfer amount
        String transferAmount = "111";

        //Transfer funds
        transferFunds(overviewPage, driver, transferAmount, account1ID, newAccount);

        // Get balance before bill payment
        String initialBalance = overviewPage.getBalanceList().getFirst();

        //Transaction details
        String recipientAccount = "32561";
        String billAmount = "125.5";
        makePayment(overviewPage, driver, configLoader, recipientAccount, initialBalance, billAmount, account1ID);


        // Get balance after transactions
        String account1Balance = overviewPage.getBalanceList().getFirst();

        verifyTransactions(overviewPage, driver, configLoader, account1ID, account1Balance, transferAmount, billAmount);
    }

    public static void verifyTransactions(OverviewPageActions overviewPage,
                                           WebDriver driver,
                                           ConfigurationLoader configLoader,
                                           String account1ID,
                                           String account1Balance,
                                           String transferAmount,
                                           String billAmount) {

        //Make initialization
        AccountActivityPageActions accountActivityPage = new AccountActivityPageActions(driver);

        //Open account info for the first account
        overviewPage.clickAccount(account1ID);

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Account Activity"), "Account Activity page not loaded");


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
        boolean openAccountTransaction = false;
        boolean containsFoundsTransfer = false;
        boolean containsBillPayment = false;

        for (String transaction : transactions) {
            if (transaction.contains("Funds Transfer Sent $" + transferAmount) &&
                    openAccountTransaction){
                containsFoundsTransfer = true;
            }
            if (transaction.contains("Funds Transfer Sent $100.00")){
                openAccountTransaction = true;
            }
            if (transaction.contains("Bill Payment to " + configLoader.getProperty("firstName") + " " + configLoader.getProperty("lastName") + " $" + billAmount)){
                containsBillPayment = true;
            }
        }

        System.out.println("Initial transaction found - " + openAccountTransaction);
        Assert.assertTrue(openAccountTransaction,
                "Open Account not found");
        System.out.println("Funds Transfer found - " + containsFoundsTransfer);
        Assert.assertTrue(containsFoundsTransfer,
                "Funds Transfer not found");
        System.out.println("Bill Payment found - " + containsBillPayment);
        Assert.assertTrue(containsBillPayment,
                "Bill Payment not found");
    }
}
