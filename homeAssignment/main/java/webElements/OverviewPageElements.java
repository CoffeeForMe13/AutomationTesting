package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPageElements {

    private final WebDriver driver;

    public OverviewPageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement welcomeMessage(){
        return driver.findElement(By.cssSelector("#leftPanel > p"));
    }

    public WebElement LogOutLink(){
        return driver.findElement(By.cssSelector("a[href^='logout.htm']"));
    }
}
