package org.antonkhmarun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailYandexLogin {

    WebDriver driver;

    public MailYandexLogin(WebDriver driver) {
        this.driver = driver;
    }

    By loginBtn = By.cssSelector(".HeadBanner-Button-Enter");

    public void pushLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
