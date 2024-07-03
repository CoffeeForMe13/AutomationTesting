package actions;

import org.openqa.selenium.WebDriver;
import webElements.SignUpPageElements;

public class SignUpPageActions {

    private final SignUpPageElements elements;

    public SignUpPageActions(WebDriver driver){
        this.elements = new SignUpPageElements(driver);
    }

    public void enterFirstName(String firstName){
        elements.firstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        elements.lastNameField().sendKeys(lastName);
    }

    public void enterAddress(String address){
        elements.addressField().sendKeys(address);
    }

    public void enterCity(String city){
        elements.cityField().sendKeys(city);
    }

    public void enterState(String state){
        elements.stateField().sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        elements.zipCodeField().sendKeys(zipCode);
    }

    public void enterPhoneNumber(String phoneNumber){
        elements.phoneNumberField().sendKeys(phoneNumber);
    }

    public void enterSSN(String ssn){
        elements.ssnField().sendKeys(ssn);
    }

    public void enterUsername(String firstName){
        elements.userNameField().sendKeys(firstName);
    }

    public void enterPassword(String password){
        elements.passwordField().sendKeys(password);
    }

    public void enterConfirm(String confirmPassword){
        elements.confirmField().sendKeys(confirmPassword);
    }

    public void clickRegister(){
        elements.registerButton().click();
    }
}
