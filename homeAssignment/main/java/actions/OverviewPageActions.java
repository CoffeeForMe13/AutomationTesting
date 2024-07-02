package actions;

import org.openqa.selenium.WebDriver;
import webElements.OverviewPageElements;

public class OverviewPageActions {

    private final OverviewPageElements elements;

    public OverviewPageActions(WebDriver driver){
        this.elements = new OverviewPageElements(driver);
    }

    public String getWelcomeMessage(){
        return elements.welcomeMessage().getText();
    }

    public void clickLogOutLink(){
        elements.LogOutLink().click();
    }

}
