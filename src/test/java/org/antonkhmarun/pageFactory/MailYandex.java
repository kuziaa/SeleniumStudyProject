package org.antonkhmarun.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailYandex {

    public WebDriver driver;

    public MailYandex(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".user-account_left-name > .user-account__name")
    private WebElement userAccount;

    @FindBy(css = ".count-me .user-pic__image")
    private WebElement userAccountSettingsBtn;

    @FindBy(css = ".legouser__menu-item_action_exit")
    private WebElement logOutBtn;


    public String getUserName() {
        return userAccount.getAttribute("innerText");
    }

    public WebElement getUserAccount() {
        return userAccount;
    }

    public void pushUserAccountSettingsBtn() {
        userAccountSettingsBtn.click();
    }

    public void pushLogOutBtn() {
        logOutBtn.click();
    }
}
