package tests;

import Actions.Dashboard;
import Actions.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class LoginTrainer extends BaseTest {

    //Declarations
    private Login login = null;
    private Dashboard dashboard = null;

    @Test
    public void loginTrainer() {

        //Create test
        initTest("Login trainer");

        //Make initializations
        login = new Login(driver);
        dashboard = new Dashboard(driver);

        Assert.assertTrue(login.getLoginText().equalsIgnoreCase("LOGIN"),"not on the login page");

        //Declare email and password variables
        String email = "adi@adi123.com";
        String password = "1111";

        //Try to login
        login.login(email, password);
        waitFor("#userNameDisplay", "#errorForbiddenAccess",5);
        if(!login.errorForbiddenAccessText().isEmpty()){
            Assert.fail("Incorrect credentials! Failed to login");
        }
        else {
            Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"Account mismatch");
        }
    }


}
