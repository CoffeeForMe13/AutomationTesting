package tests;

import actions.HomePageActions;
import actions.OverviewPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.ConfigLoader;
import utilities.BaseTestFunctionality;

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
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(configLoader, driver);

        //Log Out
        overviewPage.clickLogOutLink();

        //Check if log out was successful
        String expectedText = "atm services";
        String ATMServicesText = homePage.getATMServicesText();

        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());


    }
}
