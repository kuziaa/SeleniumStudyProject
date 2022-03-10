package org.antonkhmarun.test;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.MailYandexLogin;
import org.antonkhmarun.pageFactory.MailYandex;
import org.antonkhmarun.pageFactory.MailYandexPassword;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTest extends BaseTest {

    public static MailYandexLogin mailYandexLogin;
    public static MailYandexPassword mailYandexPassword;
    public static MailYandex mailYandex;

    @ParameterizedTest
    @Step("Type {login} / {password}.")
    @Description("Test checks possibility of login to yandex.mail")
    @CsvFileSource(resources = "/Login_Password.csv", numLinesToSkip = 1)
    public void loginTest(String login, String password) throws InterruptedException {

        assertTrue(false);
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
//        Thread.sleep(2000);

        wait.until(ExpectedConditions.visibilityOf(mailYandex.getUserAccount()));
        
        String userName = mailYandex.getUserName();

        assertEquals(login, userName, "Correct login name is displayed");
    }
}
