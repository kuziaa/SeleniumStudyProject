package org.antonkhmarun;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LogInTest {

    public static LoginPage loginPage;
    public static PassportYandexPage passportYandexPage;
    public static MailYandexPage mailYandexPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        passportYandexPage = new PassportYandexPage(driver);
        mailYandexPage = new MailYandexPage(driver);
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void loginTest() {

        loginPage.clickLoginBtn();

        passportYandexPage.inputLogin(ConfProperties.getProperty("login"));
        passportYandexPage.clickLoginBtn();
        passportYandexPage.inputPassword(ConfProperties.getProperty("password"));
        passportYandexPage.clickLoginBtn();

        String userName = mailYandexPage.getUserName();

        Assert.assertEquals(ConfProperties.getProperty("login"), userName);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
