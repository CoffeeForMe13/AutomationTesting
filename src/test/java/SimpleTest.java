import Actions.SimpleActions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class SimpleTest extends BaseTest {

    @Test
    public void firstTest(){

        initTest("Test");

        driver.get("http:apptest.go.ro:9999/login");//open link

        String expectedText = "Login";//        String expectedText = "LOGIN";

        SimpleActions simpleActions = new SimpleActions(driver);
        String loginText = simpleActions.getLoginText();

        Assert.assertEquals(loginText.toLowerCase(),expectedText.toLowerCase());//        Assert.assertEquals(loginText,expectedText);
//        Assert.assertTrue(loginText.equalsIgnoreCase(expectedText));//        Assert.assertTrue(loginText.contains(expectedText));
        System.out.println(loginText);
        System.out.println(expectedText);
    }
}
