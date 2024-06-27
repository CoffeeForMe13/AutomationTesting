package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;

public class Login {

    private LoginElements element;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
    }

    public void clickRegisterButton(){
        element.registerButton().click();
    }

    public void enterEmail(String email){
        element.userEmail().sendKeys(email);
    }

    public void enterPassword(String password){
        element.userPassword().sendKeys(password);
    }

    public void clickLogin(){
        element.submitButton().click();
    }

    public String getLoginText(){
        return element.loginText().getText();
    }

    public String errorForbiddenAccessText(){
        return element.errorForbiddenAccess().getText();
    }


}
