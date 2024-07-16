package tests;

import actions.CustomerLookupPageActions;
import actions.HomePageActions;
import actions.OverviewPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.LoginTest.login;
import static tests.RegisterTest.signUpActions;

public class ForgotLoginInfoTest extends BaseTestFunctionality {

    @Test
    public void forgotLoginInfo(){

        //Create test
        initTest("Forgot Login Info Test");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        CustomerLookupPageActions customerLookupPage = new CustomerLookupPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/CornelMoroi.properties");

        findCustomer(overviewPage, driver, configLoader);
    }

    @Test
    public void forgotLoginInfo2(){

        //Create test
        initTest("Forgot Login Info Test2");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        CustomerLookupPageActions customerLookupPage = new CustomerLookupPageActions(driver);

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        findCustomer(overviewPage, driver, configLoader);
    }

    public static void findCustomer(OverviewPageActions overviewPage, WebDriver driver, ConfigurationLoader configLoader) {

        //Make initializations
        HomePageActions homePage = new HomePageActions(driver);
        CustomerLookupPageActions customerLookupPage = new CustomerLookupPageActions(driver);

        //Ensure that account exists
        try{
            //SignUp
            signUpActions(configLoader,driver);
        } catch (Exception e){
            //Login
            login(overviewPage, configLoader, driver);
        }

        //Log Out
        overviewPage.clickLogOutLink();

        //Check if log out was successful
        String expectedText = "atm services";
        String ATMServicesText = homePage.getATMServicesText();

        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());


        //Navigate to Forgot Login Info page
        homePage.clickForgotLoginInfoLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Customer Lookup"), "Customer Lookup page not loaded");


        customerLookupPage.enterFirstName(configLoader.getProperty("firstName"));
        customerLookupPage.enterLastName(configLoader.getProperty("lastName"));
        customerLookupPage.enterAddress(configLoader.getProperty("address"));
        customerLookupPage.enterCity(configLoader.getProperty("city"));
        customerLookupPage.enterState(configLoader.getProperty("state"));
        customerLookupPage.enterZipCode(configLoader.getProperty("zipCode"));
        customerLookupPage.enterSSN(configLoader.getProperty("ssn"));
        customerLookupPage.clickFindMyLoginInfoButton();

        //Check if registration was successful
        System.out.println(customerLookupPage.getLookupMessage());
        Assert.assertEquals(customerLookupPage.getLookupMessage(),
                "Customer Lookup",
                "Message invalid");
        System.out.println(customerLookupPage.getFoundUsername());
        Assert.assertEquals(customerLookupPage.getFoundUsername(),
                configLoader.getProperty("userName"),
                "Incorrect username");
        System.out.println(customerLookupPage.getFoundPassword());
        Assert.assertEquals(customerLookupPage.getFoundPassword(),
                configLoader.getProperty("password"),
                "Incorrect password");
    }
}
