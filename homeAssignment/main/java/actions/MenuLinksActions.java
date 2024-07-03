package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.MenuLinks;

import java.time.Duration;

public class MenuLinksActions {

    private final MenuLinks elements;
    public final Wait<WebDriver> wait;

    public MenuLinksActions(WebDriver driver){
        this.elements = new MenuLinks(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOpenNewAccountLink(){
        elements.openNewAccountLink().click();
    }

    public void clickAccountsOverviewLink(){
        elements.accountsOverviewLink().click();
    }

    public void clickTransferFundsLink(){
        elements.transferFundsLink().click();
    }

    public void clickBillPayLink(){
        elements.billPayLink().click();
    }

    public void clickFindTransactionLink(){
        elements.findTransactionLink().click();
    }

    public void clickUpdateContactInfoLink(){
        elements.updateContactInfoLink().click();
    }

    public void clickRequestLoanLink(){
        elements.requestLoanLink().click();
    }

    public void clickLogOutLink(){
        elements.logOutLink().click();
    }

}
