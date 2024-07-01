package tests;

import actions.HomePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.ConfigLoader;
import utilities.BaseTestFunctionality;

public class LoginTest extends BaseTestFunctionality {

    @Test
    public void logIntoAccount(){

        //Create test
        initTest("Log into Account");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);

        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        homePage.enterUsername(configLoader.getProperty("userName"));
        homePage.enterPassword(configLoader.getProperty("password"));
        homePage.clickSubmit();


        //Check if registration was successful
        Assert.assertTrue(homePage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("firstName") +
                " " +
                configLoader.getProperty("lastName")),"Account mismatch");

    }
}
