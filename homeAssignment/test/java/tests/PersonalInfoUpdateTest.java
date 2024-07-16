package tests;

import actions.OverviewPageActions;
import actions.UpdateInfoPageActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;
import utilities.ConfigurationLoader;

import static tests.LoginTest.login;

public class PersonalInfoUpdateTest extends BaseTestFunctionality {

    @Test
    public void personalInfoUpdateTest(){

        //Create test
        initTest("Personal Info Update");

        //Get registration data
        ConfigurationLoader configLoader = new ConfigurationLoader("homeAssignment/test/resources/properties/MirceaGrad.properties");

        //Login
        login(overviewPage, configLoader, driver);

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");


        //New info
        String newAddress = configLoader.getProperty("newAddress");
        String newCity = configLoader.getProperty("newCity");
        String newState = configLoader.getProperty("newState");

        //Update personal info
        updatePersonalInfo(overviewPage, driver, newAddress, newCity, newState);

    }

    public static void updatePersonalInfo(OverviewPageActions overviewPage, WebDriver driver, String newAddress, String newCity, String newState) {

        //Make initialization
        UpdateInfoPageActions updateInfoPage = new UpdateInfoPageActions(driver);

        //Navigate to Update Contact Info page
        overviewPage.clickUpdateContactInfoLink();

        //Check the page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Update Profile"), "Update Profile page not loaded");


        updateInfoPage.emptyAddress();
        updateInfoPage.modifyAddress(newAddress);
        updateInfoPage.emptyCity();
        updateInfoPage.modifyCity(newCity);
        updateInfoPage.emptyState();
        updateInfoPage.modifyState(newState);
        updateInfoPage.clickUpdateProfileButton();

        //Check result message
        System.out.println(updateInfoPage.getProfileUpdateMessage());
        Assert.assertEquals(updateInfoPage.getProfileUpdateMessage(),"Profile Updated","Update Profile failed");

        updateInfoPage.clickAccountsOverviewLink();

        //Check to page title
        System.out.println(getPageTitle(driver));
        Assert.assertTrue(getPageTitle(driver).equalsIgnoreCase("ParaBank | Accounts Overview"), "Overview page not loaded");

    }
}
