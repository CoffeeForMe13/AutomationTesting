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
    private Login login = null;
    private Dashboard dashboard = null;

    @Test
    public void loginTrainer() {

        initTest("Login trainer");
        login = new Login(driver);
        dashboard = new Dashboard(driver);

        Assert.assertTrue(login.getLoginText().equalsIgnoreCase("LOGIN"),"failed to return to the Login page");

//        String email = RegisterUser.getEmail();
//        String password = RegisterUser.getPassword();
        String email = "adi@adi.com";
        String password = "1111";

        login.enterEmail(email);
        login.enterPassword(password);
        login.clickLogin();

        /*
         * Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(2));
         * wait.until(d -> revealed.isDisplayed());
         */

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameDisplay")));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard.getWebElement()));


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameDisplay")));

        Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"failed to login");
    }
}
