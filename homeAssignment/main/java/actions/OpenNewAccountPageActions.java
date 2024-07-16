package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.OpenNewAccountPageElements;

import java.util.List;
import java.util.stream.Collectors;

public class OpenNewAccountPageActions extends MenuLinksActions{

    private final OpenNewAccountPageElements elements;

    public OpenNewAccountPageActions(WebDriver driver){
        super(driver);
        this.elements = new OpenNewAccountPageElements(driver);
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
        return elements.accountType().getAllSelectedOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void selectAccount(String account){
        wait.until(_ -> elements.defaultAccountOption().isDisplayed());
        elements.account().selectByValue(account);
    }

    public List<String> getSelectedAccount(){
        return elements.account().getAllSelectedOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickOpenNewAccountButton(){
        wait.until(_ -> elements.openNewAccountButton().isDisplayed());
        elements.openNewAccountButton().click();
    }

    public String getResultMessage(){
        wait.until(_ -> elements.resultMessage().isDisplayed());
        return elements.resultMessage().getText();
    }

    public String getNewAccountNumber(){
        return elements.newAccountNumber().getText();
    }

    public List<String> getAccountsList(){
        wait.until(d -> elements.defaultAccountOption().isDisplayed());
        return elements.account().getOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
