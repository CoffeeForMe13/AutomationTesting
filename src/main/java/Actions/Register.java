package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Register {

    private RegisterElements element = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public Register(WebDriver driver){
        this.element = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getSingUpText(){
        return element.signupText().getText();
    }

    public void setFirstname(String firstname){
        element.firstname().sendKeys(firstname);
    }

    public void setLastname(String lastname){
        element.lastname().sendKeys(lastname);
    }

    public void setPhoneNumber(String phoneNumber){
        element.phoneNumber().sendKeys(phoneNumber);
    }

    public void setEmail(String email){
        element.email().sendKeys(email);
    }

    public void setPassword(String password){
        element.password().sendKeys(password);
    }

    public void city(String city){
        element.city().sendKeys(city);
    }

    public void checkCustomer(){
        element.customer().click();
    }

    public void checkTrainer(){
        element.trainer().click();
    }

    public void clickSubmitButton(){
        element.submit().click();
    }

    private void completeFields(String phoneNumber, String mail) {

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");

        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String city = configLoader.getProperty("city");
        String password = configLoader.getProperty("password");

        setFirstname(firstName);
        setLastname(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(mail);
        city(city);
        setPassword(password);
    }

    private void completeFields() {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");

        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String mail = configLoader.getProperty("mail");
        String city = configLoader.getProperty("city");
        String password = configLoader.getProperty("password");

        setFirstname(firstName);
        setLastname(lastName);
        setPhoneNumber(phoneNumber);
        setEmail(mail);
        city(city);
        setPassword(password);
    }

    public void registerUser(boolean isTrainer){

        completeFields("1423321", "adi@adi4.com");

        if(isTrainer){
            checkTrainer();
        }
        else {
            checkCustomer();
        }

        clickSubmitButton();
    }

    public void registerUser(String email, String phoneNumber, boolean isTrainer){

        completeFields(phoneNumber, email);

        if(isTrainer){
            checkTrainer();
        }
        else {
            checkCustomer();
        }

        clickSubmitButton();
    }


}
