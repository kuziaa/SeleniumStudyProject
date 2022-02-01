package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pages.BootstrapDownloadProgressDemo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DownloadingTest {

    BootstrapDownloadProgressDemo bootstrapDownloadProgressDemo;
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Test
    public void downloadingTo50Percent() {
        bootstrapDownloadProgressDemo = new BootstrapDownloadProgressDemo(driver);
        driver.get(ConfProperties.getProperty("bootstrapDownloadProgressDemo"));
        bootstrapDownloadProgressDemo.clickDownloadBtn();

        wait.until((ExpectedCondition<Boolean>) driver -> bootstrapDownloadProgressDemo.isPercentageGreaterOrEqual50());

        driver.navigate().refresh();
        assertEquals(bootstrapDownloadProgressDemo.getDownloadedPercent(), 0);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
