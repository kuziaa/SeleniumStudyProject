package org.antonkhmarun;

import org.antonkhmarun.pages.LoginPage;
import org.antonkhmarun.pages.MailYandexPage;
import org.antonkhmarun.pages.PassportYandexPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest {

    public static LoginPage loginPage;
    public static PassportYandexPage passportYandexPage;
    public static MailYandexPage mailYandexPage;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
    }

    @BeforeEach
    public void beforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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

        // explicit waiter
        Thread.sleep(2000);
        
        String userName = mailYandexPage.getUserName();

        assertEquals(login, userName);
    }

    @AfterEach
    public void tearDown() {
        driver.close();
    }
}
