package utilities;

import actions.OverviewPageActions;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.File;

public class BaseTestFunctionality {

    public WebDriver driver;
    public OverviewPageActions overviewPage;

    private ExtentTest extentTest;
    private ScreenshotUtilities screenshotUtilities;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        screenshotUtilities = new ScreenshotUtilities(driver);
        driver.get("https://parabank.parasoft.com/parabank/index.htm");//open link
        driver.manage().window().maximize();

        overviewPage = new OverviewPageActions(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        ReportingManager.getInstance().flush();
    }

    /**
     * This method populates the test report
     *
     * @param result Contains information about the test
     */
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case Failed: " +
                    result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case Passed: " +
                    result.getName(), ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case Skipped: " +
                    result.getName(), ExtentColor.YELLOW));
        }

    }

    public void initTest(String testName) {
        extentTest = ReportingManager.createTest(testName);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public static String getPageTitle(WebDriver driver){
        return driver.getTitle();
    }

    private void captureAndSaveFailureScreenshot(String testName) {
        //Create a new folder, if it doesn't exist
        File screenshotDirectory = new File("Screenshots");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdir();
        }

        //Capture and save screenshot
        screenshotUtilities.captureAndSaveScreenshots(testName);

    }
}
