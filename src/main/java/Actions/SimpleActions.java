package Actions;

import WebElements.SimpleElements;
import org.openqa.selenium.WebDriver;

public class SimpleActions {

    private SimpleElements elements;

    public SimpleActions(WebDriver driver){
        this.elements = new SimpleElements(driver);
    }


    public String getLoginText(){
        return elements.loginText().getText();
    }

}
