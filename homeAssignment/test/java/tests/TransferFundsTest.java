package tests;

import actions.OpenNewAccountPageActions;
import actions.OverviewPageActions;
import actions.TransferFundsPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.LoginTest.login;

public class TransferFundsTest extends BaseTestFunctionality {

    @Test
    public void foundsTransfer(){

        //Create test
        initTest("Transfer founds between accounts");

        //Make initialization
        OverviewPageActions overviewPage = new OverviewPageActions(driver);
        TransferFundsPageActions transferFundsPage = new TransferFundsPageActions(driver);
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Check if the number of accounts
        if(overviewPage.getNoOfAccounts() == 1) {
            //Get account ID
            String account = overviewPage.getAccountList().getFirst();

            //Go to Open New Account
            overviewPage.clickOpenNewAccountLink();

            //Check page title
            System.out.println(getPageTitle());
            Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Open Account"), "Overview page not loaded");


            //Set account type
            openNewAccountPage.selectAccountType("CHECKING");

            //Set account
            openNewAccountPage.selectAccount(account);

            //Check selected options
            System.out.println("Number of 'Account Type' selected is " + openNewAccountPage.getSelectedAccountType().size());
            Assert.assertEquals(openNewAccountPage.getSelectedAccountType().getFirst(), "CHECKING", "");
            System.out.println("Number of 'Account' selected is " + openNewAccountPage.getSelectedAccount().size());
            Assert.assertEquals(openNewAccountPage.getSelectedAccount().getFirst(), account, "");

            //Click OPEN NEW ACCOUNT
            openNewAccountPage.clickOpenNewAccountButton();

            //Check result message
            Assert.assertTrue(openNewAccountPage.getResultMessage().
                    equalsIgnoreCase("Account Opened!"), "Account not created");

            //Get new account number
            String newAccount = openNewAccountPage.getNewAccountNumber();

            //Go to overview page
            openNewAccountPage.clickAccountsOverviewLink();

            //Check if the new account is in the list
            Assert.assertTrue(overviewPage.checkAccount(newAccount), "Account not found");

        }


        //Get the accounts balance
        List<String> accounts = overviewPage.getAccountList();
        List<String> balances = overviewPage.getBalanceList().stream().map(e -> e.replace("$","")).toList();
        double expectedTotalValue = Double.parseDouble(balances.getFirst()) + Double.parseDouble(balances.get(1));

        //Navigate to Transfer Founds
        overviewPage.clickTransferFundsLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Transfer Funds"), "Transfer Funds page not loaded");


        //Fill in the transaction details
        String transferAmount = "100";
        transferFundsPage.typeAmount(transferAmount);
        transferFundsPage.selectFromAccount(accounts.getFirst());
        transferFundsPage.selectToAccount(2);

        //Check if the selected options are right
        Assert.assertEquals(transferFundsPage.getSelectedFromAccount().size(), 1);
        Assert.assertEquals(transferFundsPage.getSelectedToAccount().size(), 1);
        Assert.assertEquals(accounts.getFirst(), transferFundsPage.getSelectedFromAccount().getFirst());
        Assert.assertEquals(accounts.get(1), transferFundsPage.getSelectedToAccount().getFirst());

        //Press Transfer
        transferFundsPage.clickTransferButton();

        //Check transaction result message
        System.out.println(transferFundsPage.getTransactionResultMessage());
        Assert.assertTrue(transferFundsPage.getTransactionResultMessage().equalsIgnoreCase("Transfer Complete!"), "Transaction Failed");

        //Go to accounts overview
        transferFundsPage.clickAccountsOverviewLink();

        //Check to page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Check if the transaction was successful
        List<String> currentBalances = overviewPage.getBalanceList().stream().map(e -> e.replace("$","")).toList();
        double currentTotalValue = Double.parseDouble(currentBalances.getFirst()) + Double.parseDouble(currentBalances.get(1));

        Assert.assertEquals(currentTotalValue, expectedTotalValue,"Sums don't match");
        Assert.assertEquals(Double.parseDouble(balances.getFirst()) - Double.parseDouble(transferAmount),
                Double.parseDouble(currentBalances.getFirst()),
                "wrong amount extracted from account");
        Assert.assertEquals(Double.parseDouble(balances.get(1)) + Double.parseDouble(transferAmount),
                Double.parseDouble(currentBalances.get(1)),
                "wrong amount extracted from account");



        System.out.println(transferFundsPage.getPageHeaderText());
        System.out.println(getPageTitle());


    }

}
