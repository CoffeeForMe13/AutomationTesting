package webElements;

import org.openqa.selenium.WebDriver;

public class RequestLoanPageElements extends MenuLinks {

    private final WebDriver driver;

    public  RequestLoanPageElements(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
}
