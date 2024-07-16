package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class OverviewPageElements {

    private final WebDriver driver;

    public OverviewPageElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement welcomeMessage(){
        return driver.findElement(By.cssSelector("#leftPanel > p"));
    }

//    public List<WebElement> noOfAccounts(){
//        return driver.findElements(By.cssSelector("#accountTable > tbody > tr"));
//    }

    public WebElement accountNo1(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(1) a"));
    }

    public WebElement accountNo2(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(2) a"));
    }

    public List<WebElement> accountsList(){
        return driver.findElements(By.cssSelector("#accountTable a"));
    }

//    public List<WebElement> accountIDWEList(){
//        return driver.findElements(By.cssSelector("#accountTable > tbody > tr > td:nth-child(1) > a"));
//    }

    public WebElement accountNo1Balance(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(1) > td:nth-child(2)"));
    }

    public WebElement accountNo2Balance(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(2) > td:nth-child(2)"));
    }

    public List<WebElement> balanceList(){
        return driver.findElements(By.cssSelector("#accountTable tbody td:nth-child(2)"));
    }
}
