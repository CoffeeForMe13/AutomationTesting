package actions;

import org.openqa.selenium.WebDriver;
import webElements.UpdateInfoPageElements;

public class UpdateInfoPageActions extends MenuLinksActions {

    private final UpdateInfoPageElements elements;

    public UpdateInfoPageActions(WebDriver driver) {
        super(driver);
        this.elements = new UpdateInfoPageElements(driver);
    }

    public void emptyAddress(){
        wait.until(_ -> elements.addressField().isDisplayed());
        wait.until(_ -> !elements.addressField().getAttribute("value").isEmpty());
        elements.addressField().clear();
    }

    public void emptyCity(){
        wait.until(_ -> elements.cityField().isDisplayed());
        wait.until(_ -> !elements.cityField().getAttribute("value").isEmpty());
        elements.cityField().clear();
    }

    public void emptyState(){
        wait.until(_ -> elements.stateField().isDisplayed());
        wait.until(_ -> !elements.stateField().getAttribute("value").isEmpty());
        elements.stateField().clear();
    }

    public void modifyAddress(String address){
        wait.until(_ -> elements.addressField().isDisplayed());
        elements.addressField().sendKeys(address);
    }

    public void modifyCity(String city){
        wait.until(_ -> elements.cityField().isDisplayed());
        elements.cityField().sendKeys(city);
    }

    public void modifyState(String state){
        wait.until(_ -> elements.stateField().isDisplayed());
        elements.stateField().sendKeys(state);
    }

    public void clickUpdateProfileButton(){
        wait.until(_ -> elements.updateProfileButton().isDisplayed());
        elements.updateProfileButton().click();
    }

    public String getProfileUpdateMessage(){
        wait.until(_ -> elements.profileUpdateMessage().isDisplayed());
        return elements.profileUpdateMessage().getText();
    }
}
