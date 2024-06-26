package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class Login extends BaseTest {
    private Actions.Login login = null;

    @Test
    public void login() {

        initTest("Login");

        driver.get("http:apptest.go.ro:9999/login");//open link

        login = new Actions.Login(driver);

        Assert.assertTrue(login.getLoginText().equalsIgnoreCase("LOGIN"),"failed to return to the Login page");

        String email = RegisterUser.getEmail();
        String password = RegisterUser.getPassword();

        login.writeEmail(email);
        login.writePassword(password);
        login.clickLogin();
    }
}
