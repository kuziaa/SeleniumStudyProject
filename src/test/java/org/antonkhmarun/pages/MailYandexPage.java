package org.antonkhmarun.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailYandexPage {

    public WebDriver driver;

    public MailYandexPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".user-account_left-name > .user-account__name")
    private WebElement userAccount;


    public String getUserName() {
        return userAccount.getAttribute("innerText");
    }

    public WebElement getUserAccount() {
        return userAccount;
    }
}
