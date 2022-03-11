package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.MailYandexLogin;
import org.antonkhmarun.pageFactory.MailYandex;
import org.antonkhmarun.pageFactory.MailYandexPassword;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PageFactoryPatternLoginTest extends BaseTest {

    public static MailYandexLogin mailYandexLogin;
    public static MailYandexPassword mailYandexPassword;
    public static MailYandex mailYandex;

    @ParameterizedTest
    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 2)
    public void loginTest(String login, String password) throws IOException {
        mailYandexLogin = new MailYandexLogin(driver);
        mailYandexPassword = new MailYandexPassword(driver);
        mailYandex = new MailYandex(driver);

        driver.get(ConfProperties.getProperty("loginPage"));

        mailYandexLogin.clickLoginBtn();

        mailYandexPassword.inputLogin(login);
        mailYandexPassword.clickLoginBtn();
        mailYandexPassword.inputPassword(password);
        mailYandexPassword.clickLoginBtn();

        wait.until(ExpectedConditions.visibilityOf(mailYandex.getUserAccount()));
        String userName = mailYandex.getUserName();
        assertEquals(login, userName, "Correct login name is displayed");
    }
}
