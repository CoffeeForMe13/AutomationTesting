package actions;

import org.openqa.selenium.WebDriver;
import webElements.FindTransactionsPageElements;

public class FindTransactionsPageActions extends MenuLinksActions {

    private final FindTransactionsPageElements elements;

    public FindTransactionsPageActions(WebDriver driver){
        super(driver);
        this.elements = new FindTransactionsPageElements(driver);
    }


}
