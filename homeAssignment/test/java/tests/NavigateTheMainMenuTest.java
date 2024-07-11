package tests;

import actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import java.util.List;

import static tests.LoginTest.login;

public class NavigateTheMainMenuTest extends BaseTestFunctionality {

    @Test
    public void navigateTheMainMenu() {

        //Create test
        initTest("Navigate the main menu");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        SignUpPageActions signUpPage = new SignUpPageActions(driver);
        OverviewPageActions overviewPage = new OverviewPageActions(driver);
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);
        TransferFundsPageActions transferFundsPage = new TransferFundsPageActions(driver);
        BillPayPageActions billPayPage = new BillPayPageActions(driver);
        FindTransactionsPageActions findTransactionsPage = new FindTransactionsPageActions(driver);
        UpdateInfoPageActions updateInfoPage = new UpdateInfoPageActions(driver);
        RequestLoanPageActions requestLoanPage = new RequestLoanPageActions(driver);

        /* ********************************************************************************************************** */
//        //Navigate to Sign Up page
//        homePage.clickRegisterLink();
//
//        //Check the page title
//        System.out.println(getPageTitle());
//        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Register for Free Online Account Access"), "Register page not loaded");
//
        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MateiOlaru.properties");
//
//        signUpPage.enterFirstName(configLoader.getProperty("firstName"));
//        signUpPage.enterLastName(configLoader.getProperty("lastName"));
//        signUpPage.enterAddress(configLoader.getProperty("address"));
//        signUpPage.enterCity(configLoader.getProperty("city"));
//        signUpPage.enterState(configLoader.getProperty("state"));
//        signUpPage.enterZipCode(configLoader.getProperty("zipCode"));
//        signUpPage.enterPhoneNumber(configLoader.getProperty("phoneNumber"));
//        signUpPage.enterSSN(configLoader.getProperty("ssn"));
//        signUpPage.enterUsername(configLoader.getProperty("userName"));
//        signUpPage.enterPassword(configLoader.getProperty("password"));
//        signUpPage.enterConfirm(configLoader.getProperty("confirmPassword"));
//        signUpPage.clickRegister();
//
//        //Check if registration was successful
//        System.out.println(overviewPage.getWelcomeMessage());
//        Assert.assertTrue(overviewPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
//                configLoader.getProperty("firstName") +
//                " " +
//                configLoader.getProperty("lastName")), "Account mismatch");


        /* ********************************************************************************************************** */
//        //Log Out
//        overviewPage.clickLogOutLink();
//
//        //Check if log out was successful
//        String expectedText = "atm services";
//        String ATMServicesText = homePage.getATMServicesText();
//
//        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());


        /* ********************************************************************************************************** */
        //Login
        login(configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"),
                "Overview page not loaded");

        //Check page content
        String mainAccountID = overviewPage.getAccount1ID();
        String totalFunds = overviewPage.getAccount1Balance();
        List<String> accountsList = overviewPage.getAccountsList();


        /* ********************************************************************************************************** */
        //Navigate to Open New Account
        overviewPage.clickOpenNewAccountLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Open Account"),
                "Open Account page not loaded");

        //Check page content
        System.out.println("Number of 'Account' selected is " + openNewAccountPage.getSelectedAccount().size());
        Assert.assertEquals(openNewAccountPage.getSelectedAccount().getFirst(),
                mainAccountID,
                "Wrong account number");


        List<String> openNewAccountAccounts = openNewAccountPage.getAccountsList();
        for (String account : openNewAccountAccounts) {
            Assert.assertTrue(accountsList.contains(account), "Account does not belong to user");
        }



        /* ********************************************************************************************************** */
        //Navigate to Transfer Founds
        openNewAccountPage.clickTransferFundsLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Transfer Funds"),
                "Transfer Funds page not loaded");

        //Check page content
        Assert.assertEquals(transferFundsPage.getSelectedFromAccount().size(), 1);
        Assert.assertEquals(transferFundsPage.getSelectedToAccount().size(), 1);
        Assert.assertEquals(mainAccountID, transferFundsPage.getSelectedFromAccount().getFirst());
        Assert.assertEquals(mainAccountID, transferFundsPage.getSelectedToAccount().getFirst());


        /* ********************************************************************************************************** */
        //Navigate to Bill Pay
        transferFundsPage.clickBillPayLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Bill Pay"),
                "Bill Pay page not loaded");

        //Check page content
        Assert.assertEquals(billPayPage.getSelectFromAccount().size(),
                1,
                "Too many options selected");
        Assert.assertEquals(billPayPage.getSelectFromAccount().getFirst(),
                mainAccountID,
                "Account mismatch");
        //I could check that the dropdown from account options are the same as the list of accounts from the overview page


        /* ********************************************************************************************************** */
        //Navigate to Find Transaction
        billPayPage.clickFindTransactionLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Find Transactions"),
                "Find Transaction page not loaded");

        //Check page content
//        List<String> findTransactionAccounts = requestLoanPage.getAccounts();
//        for(String account : findTransactionAccounts){
//            Assert.assertTrue(overviewAccounts.contains(account),"Account does not belong to user");
//    }


        /* ********************************************************************************************************** */
        //Navigate to Update Contact Info
        findTransactionsPage.clickUpdateContactInfoLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Update Profile"),
                "Update Profile page not loaded");

        //Check page content
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");
        Assert.assertEquals("","s","");


        /* ********************************************************************************************************** */
        //Navigate to Request loan
        updateInfoPage.clickRequestLoanLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Request Loan"),
                "Request Loan page not loaded");

        //Check page content
//        List<String> requestLoanAccounts = requestLoanPage.getAccounts();
//        for(String account : requestLoanAccounts){
//            Assert.assertTrue(overviewAccounts.contains(account),"Account does not belong to user");
//        }

    }
}
