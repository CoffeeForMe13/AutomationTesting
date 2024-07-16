package tests;

import actions.ErrorPageActions;
import actions.HomePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.ConfigLoader;
import utilities.BaseTestFunctionality;

public class FailedLoginTest extends BaseTestFunctionality {


    @Test
    public void failedLogIntoAccount(){

        //Create test
        initTest("Failed log into Account");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        ErrorPageActions errorPage = new ErrorPageActions(driver);

        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        homePage.enterUsername(configLoader.getProperty("userName") + " 1");
        homePage.enterPassword(configLoader.getProperty("password") + "sad");
        homePage.clickSubmit();


        //Check the error message
        Assert.assertTrue(errorPage.getErrorMessage().equalsIgnoreCase(
                "The username and password could not be verified."),
                "Account mismatch");
    }
}
