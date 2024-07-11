package tests;

import actions.OpenNewAccountPageActions;
import actions.OverviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.LoginTest.login;

public class OpenNewAccountTest extends BaseTestFunctionality {

    @Test
    public void openNewAccount(){

        //Create test
        initTest("Open new account");

        //Make initialization
        OverviewPageActions overviewPage = new OverviewPageActions(driver);
        OpenNewAccountPageActions openNewAccountPage = new OpenNewAccountPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //Get account ID
        String account = overviewPage.getAccount1ID();

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
        Assert.assertEquals(openNewAccountPage.getSelectedAccountType().getFirst(),"CHECKING","");
        System.out.println("Number of 'Account' selected is " + openNewAccountPage.getSelectedAccount().size());
        Assert.assertEquals(openNewAccountPage.getSelectedAccount().getFirst(),account,"");

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
        Assert.assertTrue(overviewPage.checkAccount(newAccount),"Account not found");

    }
}
