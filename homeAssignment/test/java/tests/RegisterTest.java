package tests;

import actions.HomePageActions;
import actions.SignUpActions;
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
        SignUpActions signUp = new SignUpActions(driver);

        //Navigate to Sign Up page
        homePage.clickRegisterLink();

        //Get registration data
        ConfigLoader configLoader = new ConfigLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        signUp.enterFirstName(configLoader.getProperty("firstName"));
        signUp.enterLastName(configLoader.getProperty("lastName"));
        signUp.enterAddress(configLoader.getProperty("address"));
        signUp.enterCity(configLoader.getProperty("city"));
        signUp.enterState(configLoader.getProperty("state"));
        signUp.enterZipCode(configLoader.getProperty("zipCode"));
        signUp.enterPhoneNumber(configLoader.getProperty("phoneNumber"));
        signUp.enterSSN(configLoader.getProperty("ssn"));
        signUp.enterUsername(configLoader.getProperty("userName"));
        signUp.enterPassword(configLoader.getProperty("password"));
        signUp.enterConfirm(configLoader.getProperty("confirmPassword"));
        signUp.clickRegister();

        //Check if registration was successful
        Assert.assertTrue(homePage.getWelcomeMessage().equalsIgnoreCase("Welcome " +
                configLoader.getProperty("firstName") +
                configLoader.getProperty("lastName")),"Account mismatch");

        System.out.println(homePage.getWelcomeMessage());

    }
}
