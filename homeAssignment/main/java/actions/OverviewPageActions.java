package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.OverviewPageElements;

import java.time.Duration;
import java.util.stream.Collectors;

public class OverviewPageActions extends MenuLinksActions{

    private final OverviewPageElements elements;
    private Wait<WebDriver> wait;

    public OverviewPageActions(WebDriver driver){
        super(driver);
        this.elements = new OverviewPageElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getWelcomeMessage(){
        return elements.welcomeMessage().getText();
    }

//    public void clickLogOutLink(){
//        elements.logOutLink().click();
//    }
//
//    public void clickTransferFundsLink(){
//        elements.transferFundsLink().click();
//    }

    public int getNoOfAccounts(){
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

//    public void clickOpenNewAccountLink(){
//        elements.openNewAccountLink().click();
//    }

    public boolean checkAccount(String newAccount){
        wait.until(d -> elements.accountNo1().isDisplayed());
        return elements.accountIDWEList().stream().map(WebElement::getText).collect(Collectors.toList()).contains(newAccount);
    }


}
