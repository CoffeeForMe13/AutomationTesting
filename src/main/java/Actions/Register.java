package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;

public class Register {

    private RegisterElements element = null;

    public Register(WebDriver driver){
        this.element = new RegisterElements(driver);
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

    public void password(String password){
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


}
