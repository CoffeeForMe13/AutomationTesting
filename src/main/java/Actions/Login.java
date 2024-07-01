package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {

    private LoginElements element;
    private Wait<WebDriver> wait;

    public Login(WebDriver driver){
        this.element = new LoginElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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

    public boolean errorForbiddenAccessText(){
        try{
            wait.until(d -> element.errorForbiddenAccess().isDisplayed());
            return element.errorForbiddenAccess().isDisplayed();
        } catch (Exception e){
            return false;
        }

    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLogin();
    }


}
