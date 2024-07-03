package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuLinks {

    private WebDriver driver;

    public MenuLinks(WebDriver driver){
        this.driver = driver;
    }

    public WebElement openNewAccountLink(){
        return driver.findElement(By.cssSelector("a[href^='openaccount.htm']"));
    }

    public WebElement accountsOverviewLink(){
        return driver.findElement(By.cssSelector("a[href^='overview.htm']"));
    }

    public WebElement transferFundsLink(){
        return driver.findElement(By.cssSelector("a[href^='transfer.htm']"));
    }

    public WebElement billPayLink(){
        return driver.findElement(By.cssSelector("a[href^='billpay.htm']"));
    }

    public WebElement findTransactionLink(){
        return driver.findElement(By.cssSelector("a[href^='findtrans.htm']"));
    }

    public WebElement updateContactInfoLink(){
        return driver.findElement(By.cssSelector("a[href^='updateprofile.htm']"));
    }

    public WebElement requestLoanLink(){
        return driver.findElement(By.cssSelector("a[href^='requestloan.htm']"));
    }

    public WebElement logOutLink(){
        return driver.findElement(By.cssSelector("a[href^='logout.htm']"));
    }
}
