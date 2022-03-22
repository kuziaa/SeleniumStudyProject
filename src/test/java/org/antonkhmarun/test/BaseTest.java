package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.support.TestResultWatcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@ExtendWith(TestResultWatcher.class)
public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static DesiredCapabilities desiredCapabilitiesChrome;
    public static DesiredCapabilities desiredCapabilitiesFirefox;

    @BeforeAll
    public static void setup() {
        desiredCapabilitiesChrome = new DesiredCapabilities();
        desiredCapabilitiesChrome.setBrowserName("chrome");
        desiredCapabilitiesChrome.setPlatform(Platform.WIN10);

        desiredCapabilitiesFirefox = new DesiredCapabilities();
        desiredCapabilitiesFirefox.setBrowserName("firefox");
        desiredCapabilitiesFirefox.setPlatform(Platform.WIN10);
    }

    // Default realization
    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://10.10.8.119:4444/wd/hub"), desiredCapabilitiesChrome);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void setupDriver(String browser) throws MalformedURLException {
        switch (browser) {
            case "chrome":
                driver = new RemoteWebDriver(new URL("http://10.10.8.119:4444/wd/hub"), desiredCapabilitiesChrome);
                break;
            case "firefox":
                driver = new RemoteWebDriver(new URL("http://10.10.8.119:4444/wd/hub"), desiredCapabilitiesFirefox);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
