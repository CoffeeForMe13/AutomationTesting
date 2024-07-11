package webElements;

import org.openqa.selenium.WebDriver;

public class FindTransactionsPageElements extends MenuLinks {

    private final WebDriver driver;

    public  FindTransactionsPageElements(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


}
