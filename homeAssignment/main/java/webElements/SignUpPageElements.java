package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignUpPageElements {


    private final WebDriver driver;

    public  SignUpPageElements(WebDriver driver){
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

    public WebElement ssnField(){
        return driver.findElement(By.cssSelector("#customer\\.ssn"));
    }

    public WebElement userNameField(){
        return driver.findElement(By.cssSelector("#customer\\.username"));
    }

    public WebElement passwordField(){
        return driver.findElement(By.cssSelector("#customer\\.password"));
    }

    public WebElement confirmField(){
        return driver.findElement(By.cssSelector("#repeatedPassword"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.cssSelector("td > input[type='submit']"));
    }


}
