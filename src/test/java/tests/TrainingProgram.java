package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;

    @Test
    public void openTrainingTab(){

        initTest("Training program");

        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();

        login();
    }

    private void login() {
        String email = "adi@adi3.com";
        String password = "1111";

        login.enterEmail(email);
        login.enterPassword(password);
        login.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#userNameDisplay")));

        if(login.errorForbiddenAccessText().equalsIgnoreCase("Access forbidden!")){
            register.registerUser(true);
        }
    }

}
