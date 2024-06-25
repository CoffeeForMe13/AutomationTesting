package utile;

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



public class BaseTest {

    public WebDriver driver;
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        screenshotUtils = new ScreenshotUtils(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Aceasta metoda creaza rezultatul testului
     * This method populates the test report
     *
     * @param result
     */
    @AfterMethod
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            screenshotUtils.captureAndSaveScreenshots(result.getMethod().getMethodName());
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
        extentTest = ReportManager.createTest(testName);
    }

    private void captureAndSaveFailureScreenshot(String testName) {
        //Create a new folder, if it doesn't exist
        File screenshotDirectory = new File("Screenshots");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdir();
        }

        //Capture and save screenshot
        screenshotUtils.captureAndSaveScreenshots(testName);

    }

}
