package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pages.JavascriptAlertBoxDemo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AlertBoxtest {

    JavascriptAlertBoxDemo javascriptAlertBoxDemo;
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
    public void confirmBoxTextInsideTest() {
        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
        driver.get(ConfProperties.getProperty("basicSelectDropdownDemo"));
        javascriptAlertBoxDemo.clickJavaScriptConfirmBoxBtn();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String textOnAlert = alert.getText();
        assertEquals("Press a button!", textOnAlert, "Confirm box has correct text inside");
        alert.accept();
    }

    @Test
    public void confirmBoxMsgAfterAcceptTest() {
        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
        driver.get(ConfProperties.getProperty("basicSelectDropdownDemo"));
        javascriptAlertBoxDemo.clickJavaScriptConfirmBoxBtn();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.accept();

        assertEquals("You pressed OK!", javascriptAlertBoxDemo.getJavaScriptConfirmBoxMsg(),
                "Confirm box shows correct msg");
    }

    @Test
    public void alertBoxMsgAfterAcceptTest() {
        String msg = "Anton";

        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
        driver.get(ConfProperties.getProperty("basicSelectDropdownDemo"));
        javascriptAlertBoxDemo.clickJavaScriptAlertBoxBtn();

        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(msg);
        alert.accept();

        assertEquals("You have entered '" + msg + "' !", javascriptAlertBoxDemo.getJavaScriptAlertBoxMsg(),
                "Alert box shows correct msg");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
