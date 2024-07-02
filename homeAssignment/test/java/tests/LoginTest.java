package tests;

import actions.HomePageActions;
import actions.OverviewPageActions;
import org.openqa.selenium.WebDriver;
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
        OverviewPageActions overviewPage = new OverviewPageActions(driver);

        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(configLoader, driver);

        //Check if registration was successful
        Assert.assertTrue(overviewPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("firstName") +
                " " +
                configLoader.getProperty("lastName")),"Account mismatch");

    }

    public static void login(ConfigLoader configLoader, WebDriver driver){

        HomePageActions homePage = new HomePageActions(driver);

        //Enter data and press LOG IN
        homePage.enterUsername(configLoader.getProperty("userName"));
        homePage.enterPassword(configLoader.getProperty("password"));
        homePage.clickSubmit();
    }
}
