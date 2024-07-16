package actions;

import org.openqa.selenium.WebDriver;
import webElements.RequestLoanPageElements;

public class RequestLoanPageActions extends MenuLinksActions {

    private final RequestLoanPageElements elements;

    public RequestLoanPageActions(WebDriver driver) {
        super(driver);
        this.elements = new RequestLoanPageElements(driver);
    }

    public void enterLoanAmount(String loanAmount){
        elements.loanAmount().sendKeys(loanAmount);
    }

    public void enterDownPayment(String downPayment){
        elements.downPayment().sendKeys(downPayment);
    }

    public void selectFromAccount(String fromAccount){
        elements.fromAccount().selectByValue(fromAccount);
    }

    public void clickApplyNowButton(){
        elements.applyNowButton().click();
    }

    public String getRequestResultMessage(){
        wait.until(_ -> elements.getResultTable().isDisplayed());
        wait.until(_ -> !elements.requestResultMessage().getText().isEmpty());
        return elements.requestResultMessage().getText();
    }


}
