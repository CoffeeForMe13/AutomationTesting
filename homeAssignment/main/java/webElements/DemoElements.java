package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoElements {

    private final WebDriver driver;

    public DemoElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement ATMServices(){
        return driver.findElement(By.cssSelector(".captionone"));
    }

}
