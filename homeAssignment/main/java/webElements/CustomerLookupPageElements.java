package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLookupPageElements{

    private final WebDriver driver;

    public CustomerLookupPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement firstNameField(){
        return driver.findElement(By.cssSelector("#firstName"));
    }

    public WebElement lastNameField(){
        return driver.findElement(By.cssSelector("#lastName"));
    }

    public WebElement addressField(){
        return driver.findElement(By.cssSelector("#address\\.street"));
    }

    public WebElement cityField(){
        return driver.findElement(By.cssSelector("#address\\.city"));
    }

    public WebElement stateField(){
        return driver.findElement(By.cssSelector("#address\\.state"));
    }

    public WebElement zipCodeField(){
        return driver.findElement(By.cssSelector("#address\\.zipCode"));
    }

    public WebElement ssnField(){
        return driver.findElement(By.cssSelector("#ssn"));
    }

    public WebElement findMyLoginInfoButton(){
        return driver.findElement(By.cssSelector("td > input[type='submit']"));
    }

    public WebElement lookupMessage(){
        return driver.findElement(By.cssSelector("#rightPanel > .title"));
    }

    public WebElement loginInfo(){
        return driver.findElement(By.xpath("//div[@id='rightPanel']/p[contains(.,'Username')]"));
    }

}
