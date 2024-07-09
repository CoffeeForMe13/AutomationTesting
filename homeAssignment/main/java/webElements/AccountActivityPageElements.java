package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountActivityPageElements extends MenuLinks {

    private final WebDriver driver;

    public AccountActivityPageElements(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement accountNumber(){
        return driver.findElement(By.cssSelector("#accountId"));
    }

    public WebElement accountType(){
        return driver.findElement(By.cssSelector("#accountType"));
    }

    public WebElement accountBalance(){
        return driver.findElement(By.cssSelector("#balance"));
    }

    public WebElement accountAvailableBalance(){
        return driver.findElement(By.cssSelector("#availableBalance"));
    }

    public List<WebElement> transactionHistoryTableRows(){
        return driver.findElements(By.cssSelector("#transactionTable tr"));
    }

    public WebElement transactionHistoryTableElement(){
        return driver.findElement(By.cssSelector("#transactionTable tr td"));
    }



}
