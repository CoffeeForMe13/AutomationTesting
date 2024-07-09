package actions;

import org.openqa.selenium.WebDriver;
import webElements.CustomerLookupPageElements;

public class CustomerLookupPageActions extends MenuLinksActions {

    private final CustomerLookupPageElements elements;

    public CustomerLookupPageActions(WebDriver driver) {
        super(driver);
        this.elements = new CustomerLookupPageElements(driver);
    }

    public void enterFirstName(String firstName){
        elements.firstNameField().sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        elements.lastNameField().sendKeys(lastName);
    }

    public void enterAddress(String address){
        elements.addressField().sendKeys(address);
    }

    public void enterCity(String city){
        elements.cityField().sendKeys(city);
    }

    public void enterState(String state){
        elements.stateField().sendKeys(state);
    }

    public void enterZipCode(String zipCode){
        elements.zipCodeField().sendKeys(zipCode);
    }

    public void enterSSN(String ssn){
        elements.ssnField().sendKeys(ssn);
    }

    public void clickFindMyLoginInfoButton(){
        elements.findMyLoginInfoButton().click();
    }

    public String getLookupMessage(){
        return elements.lookupMessage().getText();
    }

    public String getFoundUsername(){
        return elements.loginInfo().getText().split("\n")[0].replace("Username: ", "");
    }

    public String getFoundPassword(){
        return elements.loginInfo().getText().split("\n")[1].replace("Password: ", "");
    }
}
