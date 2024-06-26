package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {

    private Login login = null;
    private Register register = null;

    private static String email;
    private static String password;

    public static String getPassword() {
        return password;
    }

    private static void setPassword(String password) {
        RegisterUser.password = password;
    }

    public static String getEmail() {
        return email;
    }

    private static void setEmail(String email) {
        RegisterUser.email = email;
    }

    @Test
    public void registerUser() {

        initTest("Register User");

        driver.get("http:apptest.go.ro:9999/login");//open link

        login = new Login(driver);
        register = new Register(driver);

        login.clickRegisterButton();

        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("SIGN UP"),"failed to enter Register page");

        RegisterUser.setEmail("adi@adi.com");
        RegisterUser.setPassword("1111");

        register.setFirstname("Adrian");
        register.setLastname("Marin");
        register.setPhoneNumber("0777333999");
        register.setEmail("adi@adi.com");
        register.city("Bucuresti");
        register.password("1111");
        register.checkTrainer();
        register.submit();

    }
}
