package tests;

import actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.BillPayTest.makePayment;
import static tests.LoginTest.login;
import static tests.OpenNewAccountTest.getNewAccount;
import static tests.PersonalInfoUpdateTest.updatePersonalInfo;
import static tests.TransferFundsTest.transferFunds;
import static tests.ViewTransactionsHistoryTest.verifyTransactions;

public class NavigateTheMainMenuTest extends BaseTestFunctionality {

    @Test
    public void navigateTheMainMenu() {

        //Create test
        initTest("Navigate the main menu");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);
        RequestLoanPageActions requestLoanPage = new RequestLoanPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        /* ************************************ Login / Sign Up ************************************ */

        login(overviewPage, configLoader, driver);


        /* ************************************ Open New Account ************************************ */


        //Open new account
        String newAccount = getNewAccount(overviewPage, openNewAccountPage, driver);


        /* ************************************ Accounts Overview ************************************ */



        /* ************************************ Transfer Funds ************************************ */

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

        Assert.assertEquals(currentTotalValue, expectedTotalValue,
                "Sums don't match");
        Assert.assertEquals(Double.parseDouble(balances.getFirst()) - Double.parseDouble(transferAmount),
                Double.parseDouble(currentBalances.getFirst()),
                "wrong amount extracted from account");
        Assert.assertEquals(Double.parseDouble(newAccountBalance) + Double.parseDouble(transferAmount),
                Double.parseDouble(newCurrentAccountBalance),
                "wrong amount extracted from account");


        /* ************************************ Bill Pay ************************************ */
        //Transaction details
        accounts = overviewPage.getAccountList();
        balances = overviewPage.getBalanceList().stream().map(e -> e.replace("$","")).toList();

        String recipientAccount = "32561";
        String billAmount = "125.5";
        String account = accounts.getFirst();
        String balance = balances.getFirst();

        makePayment(overviewPage, driver, configLoader, recipientAccount, balance, billAmount, account);

        //Check if the pay was successful
        String currentBalance = overviewPage.getBalanceList().getFirst().replace("$","");
        Assert.assertEquals(Double.parseDouble(currentBalance),
                Double.parseDouble(balance) - Double.parseDouble(billAmount),
                "Balance inconsistent");



        balance = overviewPage.getBalanceList().getFirst();

        verifyTransactions(overviewPage, driver, configLoader, account, balance, transferAmount, billAmount);


        /* ************************************ Find Transactions ************************************ */

        FindTransactionsPageActions findTransactionsPage = new FindTransactionsPageActions(driver);

        overviewPage.clickFindTransactionLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Find Transactions"),
                "Overview page not loaded");


        findTransactionsPage.selectAccount(account);
        findTransactionsPage.enterAmountToLookFor(billAmount);
        findTransactionsPage.clickFindByAmountFindTransactionsButton();

        //Check account transactions
        List<String> transactions = findTransactionsPage.getTableRowsToList();
        boolean containsBillPayment = false;

        for (String transaction : transactions) {
            if (transaction.contains("Bill Payment to " + configLoader.getProperty("firstName") + " " + configLoader.getProperty("lastName") + " $" + billAmount)){
                containsBillPayment = true;
            }
        }

        System.out.println("Bill Payment found - " + containsBillPayment);
        Assert.assertTrue(containsBillPayment,
                "Bill Payment not found");

        findTransactionsPage.clickAccountsOverviewLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"),
                "Overview page not loaded");



        /* ************************************ Update Contact Info ************************************ */

        //New info
        String newAddress = configLoader.getProperty("newAddress");
        String newCity = configLoader.getProperty("newCity");
        String newState = configLoader.getProperty("newState");

        //Update personal info
        updatePersonalInfo(overviewPage, driver, newAddress, newCity, newState);


        /* ************************************ Request Loan ************************************ */

        overviewPage.clickRequestLoanLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Loan Request"),
                "Loan Request page not loaded");

        requestLoanPage.enterLoanAmount("100");
        requestLoanPage.enterDownPayment("50");
        requestLoanPage.selectFromAccount(account);
        requestLoanPage.clickApplyNowButton();

        System.out.println(requestLoanPage.getRequestResultMessage());
        Assert.assertEquals(requestLoanPage.getRequestResultMessage(),
                "Loan Request Processed",
                "An error occurred while requesting a loan");

        requestLoanPage.clickAccountsOverviewLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"),
                "Overview page not loaded");


        /* ************************************ Log Out ************************************ */
        //Log Out
        overviewPage.clickLogOutLink();

        //Check if log out was successful
        String expectedText = "atm services";
        String ATMServicesText = homePage.getATMServicesText();

        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());


    }
}
