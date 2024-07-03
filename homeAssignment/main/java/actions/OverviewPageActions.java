package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.OverviewPageElements;

public class OverviewPageActions extends MenuLinksActions{

    private final OverviewPageElements elements;

    public OverviewPageActions(WebDriver driver){
        super(driver);
        this.elements = new OverviewPageElements(driver);
    }

    public String getWelcomeMessage(){
        return elements.welcomeMessage().getText();
    }

    public int getNoOfAccounts(){
        wait.until(d -> elements.accountNo1().isDisplayed());
        return elements.noOfAccounts().size() - 1;
    }

    public String getAccount1ID(){
        wait.until(d -> elements.accountNo1().isDisplayed());
        return elements.accountNo1().getText();
    }

    public String getAccount2ID(){
        return elements.accountNo2().getText();
    }

    public String getAccount1Balance(){
        wait.until(d -> elements.accountNo1Balance().isDisplayed());
        return elements.accountNo1Balance().getText();
    }

    public String getAccount2Balance(){
        wait.until(d -> elements.accountNo2Balance().isDisplayed());
        return elements.accountNo2Balance().getText();
    }

    public boolean checkAccount(String newAccount){
        wait.until(d -> elements.accountNo1().isDisplayed());
        return elements.accountIDWEList().stream().map(WebElement::getText).toList().contains(newAccount);
    }


}
