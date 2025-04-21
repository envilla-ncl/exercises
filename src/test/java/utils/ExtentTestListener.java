package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ExtentTestListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public static ThreadLocal<WebDriver> driverHolder = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        driverHolder.set(driver);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, result.getThrowable());

        WebDriver driver = driverHolder.get();
        if (driver != null) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getMethod().getMethodName());
            test.get().addScreenCaptureFromPath(screenshotPath);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
