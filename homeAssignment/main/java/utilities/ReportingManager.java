package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportingManager {

    private static ExtentReports extendReports;

    public static ExtentReports getInstance(){
        if (extendReports == null){
            String reportName = "test-report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportName);
            extendReports = new ExtentReports();
            extendReports.attachReporter(sparkReporter);
        }
        return extendReports;
    }

    public static ExtentTest createTest(String testName){
        return getInstance().createTest(testName);
    }
}
