package tests;

import actions.HomePageActions;
import actions.OverviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.LoginTest.login;

public class LogoutTest extends BaseTestFunctionality {

    @Test
    public void logOutFromAccount(){

        //Create test
        initTest("Log Out from Account");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        OverviewPageActions overviewPage = new OverviewPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
         login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

        //Log Out
        overviewPage.clickLogOutLink();

        //Check if log out was successful
        String expectedText = "atm services";
        String ATMServicesText = homePage.getATMServicesText();

        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());


    }
}
