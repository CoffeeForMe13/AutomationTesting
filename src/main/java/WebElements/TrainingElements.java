package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TrainingElements {

    private WebDriver driver;

    public  TrainingElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement generateProgram(){
        return driver.findElement(By.cssSelector(".mdc-button"));
    }

    public WebElement triceps(){
        return driver.findElement(By.xpath("//div[contains(text(),'triceps')]"));
    }

    public WebElement chest(){
        return driver.findElement(By.xpath("//div[contains(text(),'chest')]"));
    }

    public WebElement legs(){
        return driver.findElement(By.xpath("//div[contains(text(),'legs')]"));
    }

    public WebElement biceps(){
        return driver.findElement(By.xpath("//div[contains(text(),'biceps')]"));
    }

    public WebElement Monday() {
        return driver.findElement(By.cssSelector("#cdk-drop-list-1"));
    }

    public WebElement Tuesday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-2"));
    }

    public WebElement Wednesday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-3"));
    }

    public WebElement Thursday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-4"));
    }

    public WebElement Friday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-5"));
    }

    public WebElement Saturday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-6"));
    }

    public WebElement Sunday(){
        return driver.findElement(By.cssSelector("#cdk-drop-list-7"));
    }

    public WebElement logout(){
        return driver.findElement(By.cssSelector(".logout"));
    }

    public WebElement pageTitle(){
        return driver.findElement(By.xpath("//h2[contains(text(),'Training program')]"));
    }


}
