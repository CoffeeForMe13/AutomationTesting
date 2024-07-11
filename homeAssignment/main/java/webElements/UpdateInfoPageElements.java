package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateInfoPageElements {

    private final WebDriver driver;

    public UpdateInfoPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement firstNameField(){
        return driver.findElement(By.cssSelector("#customer\\.firstName"));
    }

    public WebElement lastNameField(){
        return driver.findElement(By.cssSelector("#customer\\.lastName"));
    }

    public WebElement addressField(){
        return driver.findElement(By.cssSelector("#customer\\.address\\.street"));
    }

    public WebElement cityField(){
        return driver.findElement(By.cssSelector("#customer\\.address\\.city"));
    }

    public WebElement stateField(){
        return driver.findElement(By.cssSelector("#customer\\.address\\.state"));
    }

    public WebElement zipCodeField(){
        return driver.findElement(By.cssSelector("#customer\\.address\\.zipCode"));
    }

    public WebElement phoneNumberField(){
        return driver.findElement(By.cssSelector("#customer\\.phoneNumber"));
    }

    public WebElement updateProfileButton(){
        return driver.findElement(By.cssSelector("input[type=button]"));
    }

    public WebElement profileUpdateMessage(){
        return driver.findElement(By.cssSelector("#updateProfileResult > .title"));
    }


}
