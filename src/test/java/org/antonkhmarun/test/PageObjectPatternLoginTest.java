//package org.antonkhmarun.test;
//
//import org.antonkhmarun.config.ConfProperties;
//import org.antonkhmarun.pages.MailYandex;
//import org.antonkhmarun.pages.MailYandexLogin;
//import org.antonkhmarun.pages.MailYandexPassword;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.CsvFileSource;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.IOException;
//import java.time.Duration;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class PageObjectPatternLoginTest extends BaseTest {
//
//    public static MailYandexLogin mailYandexLogin;
//    public static MailYandexPassword mailYandexPassword;
//    public static MailYandex mailYandex;
//
//    @ParameterizedTest
//    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 2)
//    public void loginTest(String login, String password) throws IOException {
//        System.out.println(login);
//        System.out.println(password);
//        mailYandexLogin = new MailYandexLogin(driver);
//        mailYandexPassword = new MailYandexPassword(driver);
//        mailYandex = new MailYandex(driver);
//
//        driver.get(ConfProperties.getProperty("loginPage"));
//
//        mailYandexLogin.pushLoginBtn();
//
//        mailYandexPassword.inputLogin(login);
//        mailYandexPassword.clickLoginBtn();
//        mailYandexPassword.inputPassword(password);
//        mailYandexPassword.clickLoginBtn();
//
//        wait.until(ExpectedConditions.visibilityOf(mailYandex.getUserAccount()));
//        String userName = mailYandex.getUserName();
//        assertEquals(login, userName, "Correct login name is displayed");
//
//        takeScreenShot(prepareFilePath("pageObjectPatternYandexMail"));
//    }
//}
