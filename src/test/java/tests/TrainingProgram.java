package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;

    @Test
    public void openTrainingTab(){

        initTest("Training program");

        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);

        String email = "adi@adi3.com";
        String password = "1111";

        login.login(email,password);

        waitFor("#userNameDisplay", "#errorForbiddenAccess",5);

        try{
            if(!login.errorForbiddenAccessText().isEmpty()){
                login.clickRegisterButton();

                Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("SIGN UP"),"failed to enter Register page");

                register.registerUser("adi@adi000.com","0-000-000-000",true);
            }
        }catch (org.openqa.selenium.NoSuchElementException noSuchElementException){
            Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"Account mismatch");
        }

    }


}
