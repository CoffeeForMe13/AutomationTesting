package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerCreatedPageElements {

    private final WebDriver driver;

    public CustomerCreatedPageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement welcomeMessage(){
        return driver.findElement(By.cssSelector("#leftPanel > p"));
    }

    public WebElement welcomeTitle(){
        return driver.findElement(By.cssSelector("#rightPanel > .title"));
    }
}
