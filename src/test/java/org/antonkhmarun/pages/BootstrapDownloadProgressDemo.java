package org.antonkhmarun.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BootstrapDownloadProgressDemo {

    public WebDriver driver;

    public BootstrapDownloadProgressDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#cricle-btn")
    private WebElement downloadBtn;

    @FindBy(css = ".percenttext")
    private WebElement percentText;

    public void clickDownloadBtn() {
        downloadBtn.click();
    }

    public int getDownloadedPercent() {
        StringBuilder percentTextStr = new StringBuilder(percentText.getText());
        percentTextStr.deleteCharAt(percentTextStr.length() - 1);
        return Integer.parseInt(percentTextStr.toString());
    }

    public Boolean isPercentageGreaterOrEqual50() {
        if(getDownloadedPercent() >= 50) {
            return Boolean.TRUE;
        }
        return null;
    }
}
