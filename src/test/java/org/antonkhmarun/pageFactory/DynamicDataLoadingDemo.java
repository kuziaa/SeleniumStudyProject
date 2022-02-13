package org.antonkhmarun.pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicDataLoadingDemo {

    public WebDriver driver;

    public DynamicDataLoadingDemo(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#save")
    private WebElement getNewUserBtn;

    @FindBy(xpath = "//img[contains(@src, 'https://randomuser')]")
    private WebElement newUserPhoto;

    public void clickGetNewUserBtn() {
        getNewUserBtn.click();
    }

    public WebElement getNewUserPhotoWebElement() {
        return newUserPhoto;
    }




}
