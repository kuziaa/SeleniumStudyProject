package org.antonkhmarun.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailYandexLogin {

    public WebDriver driver;

    public MailYandexLogin(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[contains(@class, 'control button2 button2_view_classic button2_size_mail-big button2_theme_mail-white button2_type_link HeadBanner-Button HeadBanner-Button-Enter with-shadow')]")
    private WebElement loginBtn;

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }
}
