package tests;

import actions.CustomerLookupPageActions;
import actions.HomePageActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.ConfigLoader;
import utilities.BaseTestFunctionality;

public class ForgotLoginInfoTest extends BaseTestFunctionality {

    @Test
    public void forgotLoginInfo(){

        //Create test
        initTest("Forgot Login Info Test");

        //Make initialization
        HomePageActions homePage = new HomePageActions(driver);
        CustomerLookupPageActions customerLookupPage = new CustomerLookupPageActions(driver);

        //Navigate to Forgot Login Info page
        homePage.clickForgotLoginInfoLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Customer Lookup"), "Customer Lookup page not loaded");


        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

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
