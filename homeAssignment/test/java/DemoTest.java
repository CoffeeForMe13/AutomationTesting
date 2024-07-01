import actions.DemoActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.BaseTestFunctionality;

public class DemoTest extends BaseTestFunctionality {


    @Test
    public void firstTest() {

        initTest("demoTest");

        String expectedText = "atm services";

        DemoActions demoActions = new DemoActions(driver);
        String ATMServicesText = demoActions.getATMServicesText();

        Assert.assertEquals(ATMServicesText.toLowerCase(), expectedText.toLowerCase());

        System.out.println(ATMServicesText);
        System.out.println(expectedText);
    }
}
