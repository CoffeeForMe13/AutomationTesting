package actions;

import org.openqa.selenium.WebDriver;
import webElements.RequestLoanPageElements;

public class RequestLoanPageActions extends MenuLinksActions {

    private final RequestLoanPageElements elements;

    public RequestLoanPageActions(WebDriver driver) {
        super(driver);
        this.elements = new RequestLoanPageElements(driver);
    }


}
