package org.antonkhmarun.test;

import org.antonkhmarun.config.ConfProperties;
import org.antonkhmarun.pageFactory.DynamicDataLoadingDemo;
import org.junit.jupiter.api.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class GetNewUserTest extends BaseTest {

    DynamicDataLoadingDemo dynamicDataLoadingDemo;

    @Test
    public void getNewUserTest() {
        dynamicDataLoadingDemo = new DynamicDataLoadingDemo(driver);
        driver.get(ConfProperties.getProperty("dynamicDataLoadingDemo"));
        dynamicDataLoadingDemo.clickGetNewUserBtn();

        wait.until(ExpectedConditions.visibilityOf(dynamicDataLoadingDemo.getNewUserPhotoWebElement()));

        assertTrue(dynamicDataLoadingDemo.getNewUserPhotoWebElement().isDisplayed(), "New user photo appears");
    }
}
