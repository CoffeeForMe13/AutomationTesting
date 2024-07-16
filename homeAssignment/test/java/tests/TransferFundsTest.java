package tests;

import actions.OpenNewAccountPageActions;
import actions.OverviewPageActions;
import actions.TransferFundsPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.LoginTest.login;
import static tests.OpenNewAccountTest.getNewAccount;

public class TransferFundsTest extends BaseTestFunctionality {

    @Test
    public void foundsTransfer(){

        //Create test
        initTest("Transfer founds between accounts");

        //Make initialization
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Open new account
        String newAccount = getNewAccount(overviewPage, openNewAccountPage, driver);


        //Get the accounts balance
        List<String> accounts = overviewPage.getAccountList();
        List<String> balances = overviewPage.getBalanceList().stream().map(e -> e.replace("$","")).toList();

        String newAccountBalance = balances.get(accounts.indexOf(newAccount));
        double expectedTotalValue = Double.parseDouble(balances.getFirst()) + Double.parseDouble(newAccountBalance);


        //Declare transfer amount
        String transferAmount = "111";

        //Transfer funds
        transferFunds(overviewPage, driver, transferAmount, accounts.getFirst(), newAccount);


        //Check if the transaction was successful
        List<String> currentBalances = overviewPage.getBalanceList().stream().map(e -> e.replace("$","")).toList();
        String newCurrentAccountBalance = currentBalances.get(accounts.indexOf(newAccount));
        double currentTotalValue = Double.parseDouble(currentBalances.getFirst()) + Double.parseDouble(newCurrentAccountBalance);

        Assert.assertEquals(currentTotalValue, expectedTotalValue,"Sums don't match");
        Assert.assertEquals(Double.parseDouble(balances.getFirst()) - Double.parseDouble(transferAmount),
                Double.parseDouble(currentBalances.getFirst()),
                "wrong amount extracted from account");
        Assert.assertEquals(Double.parseDouble(newAccountBalance) + Double.parseDouble(transferAmount),
                Double.parseDouble(newCurrentAccountBalance),
                "wrong amount extracted from account");


    }


    /**
     * Function used to transfer founds from fromAccount to toAccount
     * @param overviewPage Used to interact with the overview page
     * @param driver Driver passed throughout the project
     * @param transferAmount Amount of money to be transferred
     * @param fromAccount Indicates the sending account
     * @param toAccount Indicates the receiving account
     */
    public static void transferFunds(OverviewPageActions overviewPage, WebDriver driver, String transferAmount, String fromAccount, String toAccount) {

        //Make initialization
        TransferFundsPageActions transferFundsPage = new TransferFundsPageActions(driver);

        //Navigate to Transfer Founds
        overviewPage.clickTransferFundsLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Transfer Funds"), "Transfer Funds page not loaded");


        //Fill in the transaction details
        transferFundsPage.typeAmount(transferAmount);
        transferFundsPage.selectFromAccount(fromAccount);
        transferFundsPage.selectToAccount(toAccount);

        //Check if the selected options are right
        Assert.assertEquals(transferFundsPage.getSelectedFromAccount().size(), 1);
        Assert.assertEquals(transferFundsPage.getSelectedToAccount().size(), 1);
        Assert.assertEquals(fromAccount, transferFundsPage.getSelectedFromAccount().getFirst());
        Assert.assertEquals(toAccount, transferFundsPage.getSelectedToAccount().getFirst());

        //Press Transfer
        transferFundsPage.clickTransferButton();

        //Check transaction result message
        System.out.println(transferFundsPage.getTransactionResultMessage());
        Assert.assertTrue(transferFundsPage.getTransactionResultMessage().equalsIgnoreCase("Transfer Complete!"), "Transaction Failed");

        //Go to accounts overview
        transferFundsPage.clickAccountsOverviewLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

    }

}
