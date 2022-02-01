package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pages.DynamicDataLoadingDemo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class GetNewUserTest {

    DynamicDataLoadingDemo dynamicDataLoadingDemo;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void getNewUserTest() {
        dynamicDataLoadingDemo = new DynamicDataLoadingDemo(driver);
        driver.get(ConfProperties.getProperty("dynamicDataLoadingDemo"));
        dynamicDataLoadingDemo.clickGetNewUserBtn();

        wait.until(ExpectedConditions.visibilityOf(dynamicDataLoadingDemo.getNewUserPhotoWebElement()));

        assertTrue(dynamicDataLoadingDemo.getNewUserPhotoWebElement().isDisplayed(), "New user photo appears");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
