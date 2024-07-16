package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webElements.FindTransactionsPageElements;

import java.util.List;
import java.util.stream.Collectors;

public class FindTransactionsPageActions extends MenuLinksActions {

    private final FindTransactionsPageElements elements;

    public FindTransactionsPageActions(WebDriver driver){
        super(driver);
        this.elements = new FindTransactionsPageElements(driver);
    }

    public void selectAccount(String account){
//        wait.until(_ -> elements.selectAccountDropDownDefaultOption().isDisplayed());
        elements.selectAccountDropDown().selectByValue(account);
    }

    public List<String> getSelectedAccount(){
        return elements.selectAccountDropDown().getAllSelectedOptions().stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void enterIDToLookFor(String ID){
        elements.findByTransactionIDInputField().sendKeys(ID);
    }

    public void enterDateToLookFor(String date){
        elements.findByDateInputField().sendKeys(date);
    }

    public void enterStartDateToLookFor(String startDate){
        elements.findByDateRangeBeginDateInputField().sendKeys(startDate);
    }

    public void enterEndDateToLookFor(String endDate){
        elements.findByDateRangeEndDateInputField().sendKeys(endDate);
    }

    public void enterAmountToLookFor(String amount){
        elements.findByAmountInputField().sendKeys(amount);
    }

    public void clickFindByTransactionIDFindTransactionsButton(){
        elements.findByTransactionIDFindTransactionsButton().click();
    }

    public void clickFindByDateFindTransactionsButton(){
        elements.findByDateFindTransactionsButton().click();
    }

    public void clickFindByDateRangeFindTransactionsButton(){
        elements.findByDateRangeFindTransactionsButton().click();
    }

    public void clickFindByAmountFindTransactionsButton(){
        elements.findByAmountFindTransactionsButton().click();
    }

    public List<String> getTableRowsToList(){
        wait.until(_ -> !elements.transactionHistoryTableRows().isEmpty());
        return elements.transactionHistoryTableRows().stream().map(WebElement::getText).collect(Collectors.toList());
    }

}
