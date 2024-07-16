package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPageElements {

    private final WebDriver driver;

    public ErrorPageElements(WebDriver driver){
        this.driver=driver;
    }

    public WebElement errorTitle(){
        return driver.findElement(By.cssSelector("#rightPanel > .title"));
    }

    public WebElement errorMessage(){
        return driver.findElement(By.cssSelector("#rightPanel > .error"));
    }

}
