package actions;

import org.openqa.selenium.WebDriver;
import webElements.AccountActivityPageElements;

public class AccountActivityPageActions extends MenuLinksActions {

    private final AccountActivityPageElements elements;

    public AccountActivityPageActions(WebDriver driver) {
        super(driver);
        this.elements = new AccountActivityPageElements(driver);
    }
}
