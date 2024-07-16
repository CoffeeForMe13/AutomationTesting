package tests;

import actions.CustomerCreatedPageActions;
import actions.HomePageActions;
import actions.SignUpPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

public class RegisterTest extends BaseTestFunctionality {

    @Test
    public void registerAccount(){

        //Create test
        initTest("Register Account");

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Make initialization
//        overviewPage = new OverviewPageActions(driver);

        //SignUp
        signUpActions(configLoader, driver);
    }

    public static void signUpActions(ConfigurationLoader configLoader, WebDriver driver) {

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        CustomerCreatedPageActions customerCreatedPage = new CustomerCreatedPageActions(driver);

        //Navigate to Sign Up page
        homePage.clickRegisterLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Register for Free Online Account Access"),
                "Register page not loaded");
        //Make initialization
        SignUpPageActions signUpPage = new SignUpPageActions(driver);

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
        System.out.println(customerCreatedPage.getWelcomeMessage());
        Assert.assertTrue(customerCreatedPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("firstName") +
                " " +
                configLoader.getProperty("lastName")),
                "Account mismatch");
        Assert.assertTrue(customerCreatedPage.getWelcomeTitle().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("userName")),
                "Account mismatch");
    }
}
