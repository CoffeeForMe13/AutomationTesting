package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

public class TrainingProgram extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private Training training = null;

    @Test
    public void openTrainingTab(){

        //Create test
        initTest("Training program");

        //Make initializations
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        training = new Training(driver);

        //Declare email and password variables
        ConfigLoader configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String email = configLoader.getProperty("email");
        String password = configLoader.getProperty("password");

        //Try to login
        login.login(email,password);

        //Wait to load
        waitFor("#userNameDisplay", "#errorForbiddenAccess",5);

//        try{
            if(login.errorForbiddenAccessText()){
                login.clickRegisterButton();

                Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("SIGN UP"),"failed to enter Register page");

                register.registerUser("adi@adi000.com","0-000-000-000",true);

                login.login(email,password);
            }
            else {
                Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"Account mismatch");
            }
//        }catch (org.openqa.selenium.NoSuchElementException noSuchElementException){
//            Assert.assertTrue(dashboard.getUserEmailFromDashboard().equalsIgnoreCase(email),"Account mismatch");
//        }

        //Go to Training tab
        dashboard.clickTraining();
        waitFor(".mdc-button",5);

        //Generate Program
//        training.clickGenerateProgram();
        training.createAProgram();

    }



}
