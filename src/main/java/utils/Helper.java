package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Helper {

    public final static int TIMEOUT = 7;
    private static WebDriver driver;

    private Helper() {
        WebDriverManager.chromedriver().driverVersion("121.0.6167.85").setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    public static void openPage(String url) {
        getDriver().get(url);
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            new Helper();
        }
        return driver;
    }

    public static void setUpDriver() {
        getDriver();
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}