package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.support.TestResultWatcher;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.time.Duration;

@ExtendWith(TestResultWatcher.class)
public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static String sauceUrl;
    public static MutableCapabilities sauceOptions;

    @BeforeAll
    public static void setup() throws Exception {
        sauceOptions = new MutableCapabilities();
        sauceOptions.setCapability("username", ConfProperties.getProperty("sauceUserName"));
        sauceOptions.setCapability("accessKey", ConfProperties.getProperty("sauceAccessKey"));
        sauceUrl = ConfProperties.getProperty("sauceUrl");
    }

    @BeforeEach
    public void beforeEach() throws Exception {
        driver = getDriverByEnvironment();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    private RemoteWebDriver getDriverByEnvironment() throws Exception {
        String browserName = ConfProperties.getProperty("browserName");
        String browserVersion = ConfProperties.getProperty("browserVersion");
        String platformName = ConfProperties.getProperty("platformName");

        switch (browserName) {
            case "chrome": {
                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setPlatformName(platformName);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(new URL(sauceUrl), browserOptions);
            }
            case "firefox": {
                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setPlatformName(platformName);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(new URL(sauceUrl), browserOptions);
            }
            case "edge": {
                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setPlatformName(platformName);
                browserOptions.setBrowserVersion(browserVersion);
                browserOptions.setCapability("sauce:options", sauceOptions);
                return new RemoteWebDriver(new URL(sauceUrl), browserOptions);
            }
            default:
                throw new Exception("Unexpected environment");
        }
    }
}
