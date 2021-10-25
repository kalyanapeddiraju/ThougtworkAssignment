package Utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;

public class TestBase {

    //private static WebDriver webDriver;

    public static WebDriver webDriver;

    @BeforeClass

    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "chromedriver 2");
        webDriver = new ChromeDriver();

    }

    public static WebDriver getDriver() {
        return webDriver;
    }

    @AfterClass
    public static void teardown() {
        if (webDriver != null)
            webDriver.quit();
    }

}


