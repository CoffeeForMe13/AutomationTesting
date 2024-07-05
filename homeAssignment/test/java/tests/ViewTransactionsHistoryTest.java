package tests;

import actions.AccountActivityPageActions;
import actions.OverviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

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


        //Open account info dor the first account
        overviewPage.clickAccount1ID();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Account Activity"), "Account Activity page not loaded");


    }
}
