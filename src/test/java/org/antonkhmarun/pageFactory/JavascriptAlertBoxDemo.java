package org.antonkhmarun.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JavascriptAlertBoxDemo {

    public WebDriver driver;

    public JavascriptAlertBoxDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//button[contains(@class, 'btn-lg') and text() = 'Click me!']")
    private WebElement javaScriptConfirmBoxBtn;

    @FindBy(xpath = "//button[text() = 'Click for Prompt Box']")
    private WebElement javaScriptAlertBoxBtn;

    @FindBy(css = "#confirm-demo")
    private WebElement javaScriptConfirmBoxMsg;

    @FindBy(css = "#prompt-demo")
    private WebElement javaScriptAlertBoxMsg;

    public void clickJavaScriptConfirmBoxBtn() {
        javaScriptConfirmBoxBtn.click();
    }

    public void clickJavaScriptAlertBoxBtn() {
        javaScriptAlertBoxBtn.click();
    }

    public String getJavaScriptConfirmBoxMsg() {
        return javaScriptConfirmBoxMsg.getText();
    }

    public String getJavaScriptAlertBoxMsg() {
        return javaScriptAlertBoxMsg.getText();
    }
}
