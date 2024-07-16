package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.OverviewPageElements;

import java.util.List;

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
        wait.until(_ -> elements.accountNo1().isDisplayed());
        return elements.accountsList().size();
    }

    public String getAccount1ID(){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        return elements.accountNo1().getText();
    }

    public String getAccount2ID(){
        wait.until(_ -> elements.accountNo2().isDisplayed());
        return elements.accountNo2().getText();
    }

    public String getAccount1Balance(){
        wait.until(_ -> elements.accountNo1Balance().isDisplayed());
        return elements.accountNo1Balance().getText();
    }

    public String getAccount2Balance(){
        wait.until(_ -> elements.accountNo2Balance().isDisplayed());
        return elements.accountNo2Balance().getText();
    }

    public boolean checkAccount(String newAccount){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        return elements.accountsList().stream().map(WebElement::getText).toList().contains(newAccount);
    }

    public void clickAccount1ID(){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        elements.accountNo1().click();
    }

    public List<String> getAccountList(){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        return elements.accountsList().stream().map(WebElement::getText).toList();
    }

    public List<String> getBalanceList(){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        List<WebElement> balanceList = elements.balanceList();
        balanceList.removeLast();
        return balanceList.stream().map(WebElement::getText).toList();
    }

    public void clickAccount(String accountID){
        wait.until(_ -> elements.accountNo1().isDisplayed());
        elements.accountsList().get(getAccountList().indexOf(accountID)).click();
    }
}
