package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class OpenNewAccountPageElements extends MenuLinks{

    private final WebDriver driver;

    public OpenNewAccountPageElements(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public WebElement openNewAccountButton(){
        return driver.findElement(By.cssSelector("input.button"));
    }

    public WebElement resultMessage(){
        return driver.findElement(By.cssSelector("#openAccountResult>h1"));
    }

    public WebElement newAccountNumber(){
        return driver.findElement(By.cssSelector("a#newAccountId"));
    }

    public Select accountType(){
        return new Select(driver.findElement(By.cssSelector("select#type")));
    }

    public Select account(){
        return new Select(driver.findElement(By.cssSelector("select#fromAccountId")));
    }

    public WebElement defaultAccountOption(){
        return driver.findElement(By.cssSelector("select#fromAccountId>option"));
    }



//    public WebElement accountsOverviewLink(){
//        return driver.findElement(By.cssSelector("a[href^='overview.htm']"));
//    }
}
