package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.ExtentTestListener;
import utils.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Listeners;

@Listeners(utils.ExtentTestListener.class)
public class TodoExtentReportExample {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ExtentTestListener.setDriver(driver);
        driver.manage().window().maximize();
        driver.get("https://demo.playwright.dev/todomvc");
    }

    @Test
    public void addAndVerifySingleTodoWithExtent() {

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
