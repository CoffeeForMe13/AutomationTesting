package actions;

import org.openqa.selenium.WebDriver;
import webElements.BillPayPageElements;

import java.util.List;
import java.util.stream.Collectors;

public class BillPayPageActions extends MenuLinksActions {

    private final BillPayPageElements elements;

    public BillPayPageActions(WebDriver driver) {
        super(driver);
        this.elements = new BillPayPageElements(driver);
    }

    public void enterPayeeName(String name){
        elements.payeeNameField().sendKeys(name);
    }

    public void enterAddress(String address){
        elements.addressField().sendKeys(address);
    }

    public void enterCity(String name){
        elements.cityField().sendKeys(name);
    }

    public void enterState(String name){
        elements.stateField().sendKeys(name);
    }

    public void enterZipCode(String name){
        elements.zipCodeField().sendKeys(name);
    }

    public void enterPhoneNumber(String name){
        elements.phoneNumberField().sendKeys(name);
    }

    public void enterAccount(String name){
        elements.accountField().sendKeys(name);
    }

    public void enterVerifyAccount(String name){
        elements.verifyAccountName().sendKeys(name);
    }

    public void enterAmount(String name){
        elements.amountField().sendKeys(name);
    }

    public void selectFromAccount(String account){
        wait.until(_ -> elements.fromAccountDefaultOption().isDisplayed());
        elements.fromAccountField().selectByValue(account);
    }

    public List<String> getSelectFromAccount(){
        return elements.fromAccountField().getAllSelectedOptions().stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickSendPayment(){
        elements.sendPaymentButton().click();
    }

    public String getPaymentMessage(){
        wait.until(_ -> elements.paymentMessage().isDisplayed());
        return elements.paymentMessage().getText();
    }

}
