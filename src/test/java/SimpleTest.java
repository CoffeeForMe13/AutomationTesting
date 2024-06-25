import Actions.SimpleActions;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
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

    @Test
    public void extentTest(){
        ExtentReports extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("extentReportDEMO.html");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Automation Report");
        spark.config().setReportName("Extent Reports Demo");
        extent.attachReporter(spark);


        ExtentTest test = extent.createTest("Login Test");   //Create a test node in the report
        test.assignAuthor("Adrian").assignCategory("DEMO").assignCategory("Test").assignDevice("chrome 126");
        test.pass("Login Test started successfully");       //Create a test step node in the report
        test.info("URL is loaded");
        test.info("Value entered");
        test.pass("Login Test completed successfully");
            //Removed debug, fatal, error --> To match junit of testng


        ExtentTest test1 = extent.createTest("HomePage Test").assignAuthor("Adrian");   //Create a test node in the report
        test1.pass("HomePage Test started successfully");       //Create a test step node in the report
        test1.info("URL is loaded");
        test1.info("Value entered");
        test1.fail("HomePage Test completed miserably");

        extent.flush(); //Unless you call this method, your report will not be written with logs

    }
}
