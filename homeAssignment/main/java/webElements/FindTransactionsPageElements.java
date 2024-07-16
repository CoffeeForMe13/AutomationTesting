package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FindTransactionsPageElements extends MenuLinks {

    private final WebDriver driver;

    public  FindTransactionsPageElements(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public Select selectAccountDropDown(){
        return new Select(driver.findElement(By.cssSelector("#accountId")));
    }

    public WebElement selectAccountDropDownDefaultOption(){
        return driver.findElement(By.cssSelector("#transactionId option"));
    }

    public WebElement findByTransactionIDInputField(){
        return driver.findElement(By.cssSelector("#transactionId"));
    }

    public WebElement findByTransactionIDFindTransactionsButton(){
        return driver.findElement(By.cssSelector("#findById"));
    }

    public WebElement findByDateInputField(){
        return driver.findElement(By.cssSelector("#transactionDate"));
    }

    public WebElement findByDateFindTransactionsButton(){
        return driver.findElement(By.cssSelector("#findByDate"));
    }

    public WebElement findByDateRangeBeginDateInputField(){
        return driver.findElement(By.cssSelector("#fromDate"));
    }

    public WebElement findByDateRangeEndDateInputField(){
        return driver.findElement(By.cssSelector("#toDate"));
    }

    public WebElement findByDateRangeFindTransactionsButton(){
        return driver.findElement(By.cssSelector("#findByDateRange"));
    }

    public WebElement findByAmountInputField(){
        return driver.findElement(By.cssSelector("#amount"));
    }

    public WebElement findByAmountFindTransactionsButton(){
        return driver.findElement(By.cssSelector("#findByAmount"));
    }

    public List<WebElement> transactionHistoryTableRows(){
        return driver.findElements(By.cssSelector("#transactionTable tbody tr"));
    }


}
