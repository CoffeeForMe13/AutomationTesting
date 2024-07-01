package actions;

import org.openqa.selenium.WebDriver;
import webElements.DemoElements;

public class DemoActions {

    private DemoElements elements;

    public DemoActions(WebDriver driver) {
        this.elements = new DemoElements(driver);
    }

    public String getATMServicesText(){
        return elements.ATMServices().getText();
    }
}
