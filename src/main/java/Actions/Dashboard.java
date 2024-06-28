package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.WebDriver;

public class Dashboard {

    private DashboardElements elements = null;

    public Dashboard(WebDriver driver){
        elements = new DashboardElements(driver);
    }

    public String getUserEmailFromDashboard() {
        return elements.usernameDisplay().getText();
    }

    public void clickTraining(){
        elements.training().click();
    }

}
