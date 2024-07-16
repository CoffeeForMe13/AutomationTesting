package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TransferFundsPageElements {

    private final WebDriver driver;

    public TransferFundsPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement pageHeader(){
        return driver.findElement(By.cssSelector("#showOverview > h1"));
    }

    public WebElement amountField(){
        return driver.findElement(By.cssSelector("#amount"));
    }

    public Select fromAccountSelectField(){
        return new Select(driver.findElement(By.cssSelector("#fromAccountId")));
    }

    public WebElement fromAccountField(){
        return driver.findElement(By.cssSelector("#fromAccountId > option"));
    }

    public List<WebElement> selectedFromAccount(){
        return new Select(driver.findElement(By.cssSelector("#fromAccountId"))).getAllSelectedOptions();
    }

    public Select toAccountSelectField(){
        return new Select(driver.findElement(By.cssSelector("#toAccountId")));
    }

    public WebElement toAccountField(){
        return driver.findElement(By.cssSelector("#toAccountId > option"));
    }

    public List<WebElement> selectedToAccount(){
        return new Select(driver.findElement(By.cssSelector("#toAccountId"))).getAllSelectedOptions();
    }

    public WebElement transferButton(){
        return driver.findElement(By.cssSelector("input[type=submit]"));
    }

    public WebElement transactionResultMessage(){
        return driver.findElement(By.cssSelector("#showResult > h1.title"));
    }

}
