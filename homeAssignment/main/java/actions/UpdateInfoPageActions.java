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
        wait.until(d -> elements.addressField().isDisplayed());
        elements.addressField().clear();
    }

    public void emptyCity(){
        wait.until(d -> elements.cityField().isDisplayed());
        elements.cityField().clear();
    }

    public void emptyState(){
        wait.until(d -> elements.stateField().isDisplayed());
        elements.stateField().clear();
    }

    public void modifyAddress(String address){
        wait.until(d -> elements.addressField().isDisplayed());
        elements.addressField().sendKeys(address);
    }

    public void modifyCity(String city){
        wait.until(d -> elements.cityField().isDisplayed());
        elements.cityField().sendKeys(city);
    }

    public void modifyState(String state){
        wait.until(d -> elements.stateField().isDisplayed());
        elements.stateField().sendKeys(state);
    }

    public void clickUpdateProfileButton(){
        wait.until(d -> elements.updateProfileButton().isDisplayed());
        elements.updateProfileButton().click();
    }

    public String getProfileUpdateMessage(){
        wait.until(d -> elements.profileUpdateMessage().isDisplayed());
        return elements.profileUpdateMessage().getText();
    }
}
