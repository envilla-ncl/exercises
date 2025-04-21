package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String folderPath = "test-output/screenshots/";
        String fullPath = folderPath + screenshotName + ".png";
        File destination = new File(fullPath);
        destination.getParentFile().mkdirs();
        try {
            Files.copy(src.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Return relative path for ExtentReport to properly display
        return "./screenshots/" + screenshotName + ".png";
    }
}
