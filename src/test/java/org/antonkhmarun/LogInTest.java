package org.antonkhmarun;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.MailYandexLogin;
import org.antonkhmarun.pageFactory.MailYandex;
import org.antonkhmarun.pageFactory.MailYandexPassword;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest {

    public static MailYandexLogin mailYandexLogin;
    public static MailYandexPassword mailYandexPassword;
    public static MailYandex mailYandex;
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
        wait.pollingEvery(Duration.ofMillis(250));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 1)
    public void loginTest(String login, String password) throws InterruptedException {

        mailYandexLogin = new MailYandexLogin(driver);
        mailYandexPassword = new MailYandexPassword(driver);
        mailYandex = new MailYandex(driver);

        driver.get(ConfProperties.getProperty("loginPage"));

        mailYandexLogin.clickLoginBtn();

        mailYandexPassword.inputLogin(login);
        mailYandexPassword.clickLoginBtn();
        mailYandexPassword.inputPassword(password);
        mailYandexPassword.clickLoginBtn();

        // Interruption of the script (not explicit or implicit waiter)
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(mailYandex.getUserAccount()));
        
        String userName = mailYandex.getUserName();

        assertEquals(login, userName, "Correct login name is displayed");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
