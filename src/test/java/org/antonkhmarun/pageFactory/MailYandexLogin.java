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

    @FindBy(css = ".HeadBanner-Button-Enter")
    private WebElement loginBtn;

    public void clickLoginBtn() {
        loginBtn.click();
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }
}
