package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser(boolean isTrainer) {

        initTest("Register User");

        login = new Login(driver);
        register = new Register(driver);

        login.clickRegisterButton();

        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("SIGN UP"),"failed to enter Register page");

        register.registerUser(true);


    }
}
