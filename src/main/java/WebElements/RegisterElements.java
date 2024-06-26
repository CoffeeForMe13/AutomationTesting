package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElements {

    private WebDriver driver = null;

    public RegisterElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement signupText(){
        return driver.findElement(By.xpath("//h2[contains(.,'Sign Up')]"));
    }

    public WebElement firstname(){
        return driver.findElement(By.id("firstName")); // By.cssSelector("#firstName")
    }

    public WebElement lastname(){
        return driver.findElement(By.id("lastName"));
    }

    public WebElement phoneNumber(){
        return driver.findElement(By.id("phoneNumber"));
    }

    public WebElement email(){
        return driver.findElement(By.id("email"));
    }

    public WebElement password(){
        return driver.findElement(By.id("password"));
    }

    public WebElement city(){
        return driver.findElement(By.id("city"));
    }

    public WebElement customer(){
        return driver.findElement(By.id("customer"));
    }

    public WebElement trainer(){
        return driver.findElement(By.id("trainer"));
    }

    public WebElement submit(){
        return driver.findElement(By.id("submit"));
    }
}
