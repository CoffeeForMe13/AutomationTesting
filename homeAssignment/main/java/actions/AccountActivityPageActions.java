package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.AccountActivityPageElements;

import java.util.List;
import java.util.stream.Collectors;

public class AccountActivityPageActions extends MenuLinksActions {

    private final AccountActivityPageElements elements;

    public AccountActivityPageActions(WebDriver driver) {
        super(driver);
        this.elements = new AccountActivityPageElements(driver);
    }

    public String getAccountID(){
        wait.until(_ -> elements.transactionHistoryTableElement().isDisplayed());
        wait.until(_ -> elements.accountNumber().isDisplayed());
        return elements.accountNumber().getText();
    }

    public String getAccountType(){
        wait.until(_ -> elements.accountType().isDisplayed());
        return elements.accountType().getText();
    }

    public String getAccountBalance(){
        wait.until(_ -> elements.accountBalance().isDisplayed());
        return elements.accountBalance().getText();
    }

    public String getAccountAvailableBalance(){
        wait.until(_ -> elements.accountAvailableBalance().isDisplayed());
        return elements.accountAvailableBalance().getText();
    }

    public List<String> getTableRowsToList(){
        return elements.transactionHistoryTableRows().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
