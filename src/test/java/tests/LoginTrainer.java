package tests;

import Actions.Dashboard;
import Actions.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

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
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        //Try to login
        login.login(email, password);
        waitFor("#userNameDisplay", "#errorForbiddenAccess",5);
        if(!login.errorForbiddenAccessText()){
            Assert.fail("Incorrect credentials! Failed to login");
        }
        else {
            Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"Account mismatch");
        }
    }


}
