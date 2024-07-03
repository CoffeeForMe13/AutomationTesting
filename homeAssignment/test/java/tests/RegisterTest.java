package tests;

import actions.HomePageActions;
import actions.OverviewPageActions;
import actions.SignUpPageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.ConfigLoader;
import utilities.BaseTestFunctionality;

public class RegisterTest extends BaseTestFunctionality {

    @Test
    public void registerAccount(){

        //Create test
        initTest("Register Account");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        SignUpPageActions signUpPage = new SignUpPageActions(driver);
        OverviewPageActions overviewPage = new OverviewPageActions(driver);

        //Navigate to Sign Up page
        homePage.clickRegisterLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Register for Free Online Account Access"), "Register page not loaded");

        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        signUpPage.enterFirstName(configLoader.getProperty("firstName"));
        signUpPage.enterLastName(configLoader.getProperty("lastName"));
        signUpPage.enterAddress(configLoader.getProperty("address"));
        signUpPage.enterCity(configLoader.getProperty("city"));
        signUpPage.enterState(configLoader.getProperty("state"));
        signUpPage.enterZipCode(configLoader.getProperty("zipCode"));
        signUpPage.enterPhoneNumber(configLoader.getProperty("phoneNumber"));
        signUpPage.enterSSN(configLoader.getProperty("ssn"));
        signUpPage.enterUsername(configLoader.getProperty("userName"));
        signUpPage.enterPassword(configLoader.getProperty("password"));
        signUpPage.enterConfirm(configLoader.getProperty("confirmPassword"));
        signUpPage.clickRegister();

        //Check if registration was successful
        System.out.println(overviewPage.getWelcomeMessage());
        Assert.assertTrue(overviewPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("firstName") +
                " " +
                configLoader.getProperty("lastName")),"Account mismatch");

    }
}
