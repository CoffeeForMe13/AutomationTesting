package tests;

import actions.UpdateInfoPageActions;
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
        String newAddress = "Long Street";
        String newCity = "Lost Angels";
        String newState = "Bella Rosa";

        //Update personal info
        updatePersonalInfo(newAddress, newCity, newState);

    }

    private void updatePersonalInfo(String newAddress, String newCity, String newState) {

        //Make initialization
        UpdateInfoPageActions updateInfoPage = new UpdateInfoPageActions(driver);

        //Navigate to Update Contact Info page
        overviewPage.clickUpdateContactInfoLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Update Profile"), "Update Profile page not loaded");


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
