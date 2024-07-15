package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.ErrorPageElements;

import java.time.Duration;

public class ErrorPageActions extends HomePageActions {

    private final ErrorPageElements elements;
    public final Wait<WebDriver> wait;

    public ErrorPageActions(WebDriver driver){
        super(driver);
        elements = new ErrorPageElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getErrorTitle(){
        wait.until(_ -> elements.errorTitle().isDisplayed());
        return elements.errorTitle().getText();
    }

    public String getErrorMessage(){
        return elements.errorMessage().getText();
    }

}
