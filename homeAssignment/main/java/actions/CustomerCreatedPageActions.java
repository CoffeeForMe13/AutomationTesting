package actions;

import org.openqa.selenium.WebDriver;
import webElements.CustomerCreatedPageElements;

public class CustomerCreatedPageActions extends MenuLinksActions {

    private final CustomerCreatedPageElements elements;

    public CustomerCreatedPageActions(WebDriver driver){
        super(driver);
        elements = new CustomerCreatedPageElements(driver);
    }

    public String getWelcomeMessage(){
        return elements.welcomeMessage().getText();
    }

    public String getWelcomeTitle(){
        return elements.welcomeTitle().getText();
    }
}
