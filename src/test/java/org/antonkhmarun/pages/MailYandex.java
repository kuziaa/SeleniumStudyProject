package org.antonkhmarun.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MailYandex {

    WebDriver driver;

    public MailYandex(WebDriver driver) {
        this.driver = driver;
    }

    By userAccount = By.cssSelector(".user-account_left-name > .user-account__name");
    By userAccountSettingsBtn = By.cssSelector(".count-me .user-pic__image");
    By logOutBtn = By.cssSelector(".legouser__menu-item_action_exit");

    public String getUserName() {
        return driver.findElement(userAccount).getAttribute("innerText");
    }

    public WebElement getUserAccount() {
        return driver.findElement(userAccount);
    }

    public void pushUserAccountSettingsBtn() {
        driver.findElement(userAccountSettingsBtn).click();
    }

    public void pushLogOutBtn() {
        driver.findElement(logOutBtn).click();
    }
}
