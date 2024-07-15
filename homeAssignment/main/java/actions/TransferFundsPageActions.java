package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.TransferFundsPageElements;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TransferFundsPageActions extends MenuLinksActions{

    private final TransferFundsPageElements elements;

    public TransferFundsPageActions(WebDriver driver) {
        super(driver);
        this.elements = new TransferFundsPageElements(driver);
    }

    public String getPageHeaderText(){
        return elements.pageHeader().getText();
    }

    public void typeAmount(String amount){
        elements.amountField().sendKeys(amount);
    }

    public void selectFromAccount(int account){
        wait.until(_ -> elements.fromAccountField().isDisplayed());
        elements.fromAccountSelectField().selectByIndex(account - 1);
    }

    public void selectFromAccount(String  account){
        wait.until(_ -> elements.fromAccountField().isDisplayed());
        elements.fromAccountSelectField().selectByValue(account);
    }

    public void selectToAccount(int account){
        wait.until(_ -> elements.toAccountField().isDisplayed());
        elements.toAccountSelectField().selectByIndex(account - 1);
    }

    public void selectToAccount(String account){
        wait.until(_ -> elements.toAccountField().isDisplayed());
        elements.toAccountSelectField().selectByValue(account);
    }

    public List<String> getSelectedFromAccount(){
        return elements.selectedFromAccount().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<String> getSelectedToAccount(){
        return elements.selectedToAccount().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickTransferButton(){
        elements.transferButton().click();
    }

    public String getTransactionResultMessage(){
        wait.until(_ -> elements.transactionResultMessage().isDisplayed());
        return elements.transactionResultMessage().getText();
    }
}
