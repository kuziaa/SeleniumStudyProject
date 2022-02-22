package org.antonkhmarun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailYandexPassword {

    WebDriver driver;

    public MailYandexPassword(WebDriver driver) {
        this.driver = driver;
    }

    By loginField = By.xpath("//*[contains(@id, 'passp-field-login')]");
    By loginBtn = By.xpath("//*[contains(@id, 'passp:sign-in')]");
    By passwordField = By.xpath("//*[contains(@id, 'passp-field-passwd')]");

    public void inputLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
    }

    public void inputPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        getLoginBtn().click();
    }

    public WebElement getLoginBtn() {
        return driver.findElement(loginBtn);
    }
}
