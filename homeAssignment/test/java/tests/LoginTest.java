package tests;

import actions.CustomerCreatedPageActions;
import actions.ErrorPageActions;
import actions.HomePageActions;
import actions.OverviewPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.RegisterTest.signUpActions;

public class LoginTest extends BaseTestFunctionality {

    @Test
    public void logIntoAccount(){

        //Create test
        initTest("Log into Account");

//        //Make initialization
//        overviewPage = new OverviewPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);
    }

    /**
     * Simple Login action, assuming the user exists
     * @param configLoader Used to get the login data
     * @param driver WebDriver passed throughout all the tests
     */
    public static void login(ConfigurationLoader configLoader, WebDriver driver){
        HomePageActions homePage = new HomePageActions(driver);

        //Enter data and press LOG IN
        homePage.enterUsername(configLoader.getProperty("userName"));
        homePage.enterPassword(configLoader.getProperty("password"));
        homePage.clickSubmit();
    }

    /**
     * Overloaded Login method. Used to create a user if the user does not exist
     * @param overviewPage Used to interact with the Overview Page
     * @param configLoader Used to get the login data
     * @param driver WebDriver passed throughout all the tests
     */
    public static void login(OverviewPageActions overviewPage, ConfigurationLoader configLoader, WebDriver driver) {
        try{
            //Log in
            login(configLoader,driver);

            //Verify welcome message
            Assert.assertTrue(overviewPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                            configLoader.getProperty("firstName") +
                            " " +
                            configLoader.getProperty("lastName")),
                    "Account mismatch");
        } catch (Exception e){
            //Make initialization
            ErrorPageActions errorPage = new ErrorPageActions(driver);
            CustomerCreatedPageActions customerCreatedPage = new CustomerCreatedPageActions(driver);

            //Check the page title
            System.out.println(getPageTitle(driver));
            Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Error"),
                    "Error page not loaded");

            //Check error message
            System.out.println(errorPage.getErrorTitle());
            Assert.assertTrue(errorPage.getErrorTitle().equalsIgnoreCase("Error!"),
                    "Unexpected behaviour");

            //Create account
            signUpActions(overviewPage, configLoader, driver);

            customerCreatedPage.clickAccountsOverviewLink();

            //Check to page title
            System.out.println(getPageTitle(driver));
            Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

            //Verify welcome message
            Assert.assertTrue(overviewPage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                            configLoader.getProperty("firstName") +
                            " " +
                            configLoader.getProperty("lastName")),
                    "Account mismatch");
        }
    }
}
