package org.antonkhmarun;

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

    @FindBy(xpath = "//*[@class='user-account user-account_left-name user-account_has-ticker_yes user-account_has-accent-letter_yes count-me legouser__current-account legouser__current-account i-bem']//span[@class='user-account__name']")
    private WebElement userAccount;


    public String getUserName() {
        String userName = userAccount.getAttribute("innerText");
        return userName;
    }
}
