package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pages.MailYandex;
import org.antonkhmarun.pages.MailYandexLogin;
import org.antonkhmarun.pages.MailYandexPassword;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PageObjectPatternLogoutTest extends BaseTest {

    public static MailYandexLogin mailYandexLogin;
    public static MailYandexPassword mailYandexPassword;
    public static MailYandex mailYandex;

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 2)
    public void logoutTest(String login, String password) {
        System.out.println(login);
        System.out.println(password);
        mailYandexLogin = new MailYandexLogin(driver);
        mailYandexPassword = new MailYandexPassword(driver);
        mailYandex = new MailYandex(driver);

        driver.get(ConfProperties.getProperty("loginPage"));

        mailYandexLogin.pushLoginBtn();

        mailYandexPassword.inputLogin(login);
        mailYandexPassword.clickLoginBtn();
        mailYandexPassword.inputPassword(password);
        mailYandexPassword.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(mailYandex.getUserAccount()));

        mailYandex.pushUserAccountSettingsBtn();
        mailYandex.pushLogOutBtn();

        wait.until(ExpectedConditions.visibilityOf(mailYandexPassword.getLoginBtn()));
        assertTrue(mailYandexPassword.getLoginBtn().isDisplayed(), "Correctly logout");
    }
}
