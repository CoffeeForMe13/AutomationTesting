package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPageElements extends MenuLinks {

    private final WebDriver driver;

    public RequestLoanPageElements(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public WebElement loanAmount(){
        return driver.findElement(By.cssSelector("#amount"));
    }

    public WebElement downPayment(){
        return driver.findElement(By.cssSelector("#downPayment"));
    }

    public Select fromAccount(){
        return new Select(driver.findElement(By.cssSelector("select#fromAccountId")));
    }

    public WebElement applyNowButton(){
        return driver.findElement(By.cssSelector("input.button"));
    }

    public WebElement requestResultMessage(){
        return driver.findElement(By.cssSelector("#requestLoanResult h1.title"));
    }

    public WebElement getResultTable(){
        return driver.findElement(By.cssSelector("table.form"));
    }

}
