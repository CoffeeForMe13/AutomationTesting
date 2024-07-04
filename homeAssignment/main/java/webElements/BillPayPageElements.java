package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillPayPageElements extends MenuLinks {

    private final WebDriver driver;

    public BillPayPageElements(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public WebElement payeeNameField(){
        return driver.findElement(By.cssSelector("input[name='payee.name']"));
    }

    public WebElement addressField(){
        return driver.findElement(By.cssSelector("input[name='payee.address.street']"));
    }

    public WebElement cityField(){
        return driver.findElement(By.cssSelector("input[name='payee.address.city']"));
    }

    public WebElement stateField(){
        return driver.findElement(By.cssSelector("input[name='payee.address.state']"));
    }

    public WebElement zipCodeField(){
        return driver.findElement(By.cssSelector("input[name='payee.address.zipCode']"));
    }

    public WebElement phoneNumberField(){
        return driver.findElement(By.cssSelector("input[name='payee.phoneNumber']"));
    }

    public WebElement accountField(){
        return driver.findElement(By.cssSelector("input[name='payee.accountNumber']"));
    }

    public WebElement verifyAccountName(){
        return driver.findElement(By.cssSelector("input[name='verifyAccount']"));
    }

    public WebElement amountField(){
        return driver.findElement(By.cssSelector("input[name='amount']"));
    }

//    public WebElement fromAccountField(){
//        return driver.findElement(By.cssSelector("input[name='fromAccountId']"));
//    }
    public Select fromAccountField(){
        return new Select(driver.findElement(By.cssSelector("select[name='fromAccountId']")));
    }

    public WebElement fromAccountDefaultOption(){
        return driver.findElement(By.cssSelector("select[name='fromAccountId']>option"));
    }

    public WebElement sendPaymentButton(){
        return driver.findElement(By.cssSelector("input[type=button]"));
    }

    public WebElement paymentMessage(){
        return driver.findElement(By.cssSelector("#billpayResult > .title"));
    }

}
