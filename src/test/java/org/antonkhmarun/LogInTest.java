package org.antonkhmarun;

import org.antonkhmarun.pages.LoginPage;
import org.antonkhmarun.pages.MailYandexPage;
import org.antonkhmarun.pages.PassportYandexPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest {

    public static LoginPage loginPage;
    public static PassportYandexPage passportYandexPage;
    public static MailYandexPage mailYandexPage;
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
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(250));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 1)
    public void loginTest(String login, String password) throws InterruptedException {

        loginPage = new LoginPage(driver);
        passportYandexPage = new PassportYandexPage(driver);
        mailYandexPage = new MailYandexPage(driver);

        driver.get(ConfProperties.getProperty("loginpage"));

        loginPage.clickLoginBtn();

        passportYandexPage.inputLogin(login);
        passportYandexPage.clickLoginBtn();
        passportYandexPage.inputPassword(password);
        passportYandexPage.clickLoginBtn();

        // Interruption of the script (not explicit or implicit waiter)
        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(mailYandexPage.getUserAccount()));
        
        String userName = mailYandexPage.getUserName();

        assertEquals(login, userName);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
