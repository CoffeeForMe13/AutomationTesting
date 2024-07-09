package actions;

import org.openqa.selenium.WebDriver;
import webElements.HomePageElements;

public class HomePageActions {

    private final HomePageElements elements;

    public HomePageActions(WebDriver driver){
        this.elements = new HomePageElements(driver);
    }

    public void enterUsername(String username){
        elements.usernameField().sendKeys(username);
    }

    public void enterPassword(String password){
        elements.passwordField().sendKeys(password);
    }

    public void clickSubmit(){
        elements.loginButton().click();
    }

    public void clickRegisterLink(){
        elements.registerLink().click();
    }

    public void clickForgotLoginInfoLink(){
        elements.forgotLoginInfoLink().click();
    }

    public String getErrorMessage(){
        return elements.errorMessage().getText();
    }

    public String getATMServicesText(){
        return elements.ATMServices().getText();
    }
}
