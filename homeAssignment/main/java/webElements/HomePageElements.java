package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageElements {

    private WebDriver driver;

    public  HomePageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement usernameField(){
        return driver.findElement(By.cssSelector("input[type='text']"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.cssSelector("input[type='password']"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }
}
