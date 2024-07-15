package tests;

import actions.OverviewPageActions;
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


        //Navigate to Update Contact Info page
        overviewPage.clickUpdateContactInfoLink();

        //Check the page title
        System.out.println(getPageTitle());
        Assert.assertTrue(getPageTitle().equalsIgnoreCase("ParaBank | Update Profile"), "Update Profile page not loaded");


        updateInfoPage.emptyAddress();
        updateInfoPage.modifyAddress("Long Street");
        updateInfoPage.emptyCity();
        updateInfoPage.modifyCity("Lost Angels");
        updateInfoPage.emptyState();
        updateInfoPage.modifyState("Bella Rosa ");
        updateInfoPage.clickUpdateProfileButton();

        //Check result message
        System.out.println(updateInfoPage.getProfileUpdateMessage());
        Assert.assertEquals(updateInfoPage.getProfileUpdateMessage(),"Profile Updated","Update Profile failed");

    }
}
