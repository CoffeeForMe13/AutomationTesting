package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    //Declarations
    private Login login = null;
    private Register register = null;

    //Test trainer registration
    @Test
    public void registerTrainerUser() {

        //Create test
        initTest("Register Trainer User");

        //Make initializations
        register = new Register(driver);

        //Navigate to Register page
        goToRegisterPage();
        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("SIGN UP"),"failed to enter Register page");

        //Register new user
        register.registerUser(true);
    }

    private void goToRegisterPage() {

        //Make initializations
        login = new Login(driver);

        //Click the Register button and assert if the Register page is loaded
        login.clickRegisterButton();
    }
}
