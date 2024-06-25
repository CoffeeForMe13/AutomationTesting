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

        Assert.assertEquals(loginText.toLowerCase(),expectedText.toLowerCase());
        /*
         * SOME ALTERNATIVES ARE PRESENTED BELLOW
         *
         * Assert.assertEquals(loginText,expectedText);                 - THIS WILL FAIL BECAUSE OF CASE MISMATCH
         * Assert.assertTrue(loginText.equalsIgnoreCase(expectedText)); - CHECK IF EQUALS RETURNS TRUE
         * Assert.assertTrue(loginText.contains(expectedText));         - CHECK IF THE TEXT IS CONTAINED WITHIN
         */

        System.out.println(loginText);
        System.out.println(expectedText);
    }
}
