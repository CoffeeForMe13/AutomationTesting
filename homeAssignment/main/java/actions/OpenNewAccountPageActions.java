package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.OpenNewAccountPageElements;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OpenNewAccountPageActions extends MenuLinksActions{

    private final OpenNewAccountPageElements elements;
    private final Wait<WebDriver> wait;

    public OpenNewAccountPageActions(WebDriver driver){
        super(driver);
        this.elements = new OpenNewAccountPageElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void selectAccountType(String accountType){
        if(accountType.equals("CHECKING")){
            elements.accountType().selectByValue("0");
        }
        else if(accountType.equals("SAVINGS")){
            elements.accountType().selectByValue("1");
        }
    }

    public List<String> getSelectedAccountType(){
        return elements.accountType().getOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void selectAccount(String account){
        wait.until(d -> elements.defaultAccountOption().isDisplayed());
        elements.account().selectByValue(account);
    }

    public List<String> getSelectedAccount(){
        return elements.account().getOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickOpenNewAccountButton(){
        wait.until(d -> elements.openNewAccountButton().isDisplayed());
        elements.openNewAccountButton().click();
    }

    public String getResultMessage(){
        wait.until(d -> elements.resultMessage().isDisplayed());
        return elements.resultMessage().getText();
    }

    public String getNewAccountNumber(){
        return elements.newAccountNumber().getText();
    }
}
