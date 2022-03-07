//package org.antonkhmarun.test;
//
//import org.antonkhmarun.config.ConfProperties;
//import org.antonkhmarun.pageFactory.JavascriptAlertBoxDemo;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AlertBoxtest extends BaseTest{
//
//    JavascriptAlertBoxDemo javascriptAlertBoxDemo;
//
//    @Test
//    public void confirmBoxTextInsideTest() {
//        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
//        driver.get(ConfProperties.getProperty("javascriptAlertBoxDemo"));
//        javascriptAlertBoxDemo.clickJavaScriptConfirmBoxBtn();
//
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert = driver.switchTo().alert();
//        String textOnAlert = alert.getText();
//        assertEquals("Press a button!", textOnAlert, "Confirm box has correct text inside");
//        alert.accept();
//    }
//
//    @Test
//    public void confirmBoxMsgAfterAcceptTest() {
//        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
//        driver.get(ConfProperties.getProperty("javascriptAlertBoxDemo"));
//        javascriptAlertBoxDemo.clickJavaScriptConfirmBoxBtn();
//
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//        assertEquals("You pressed OK!", javascriptAlertBoxDemo.getJavaScriptConfirmBoxMsg(),
//                "Confirm box shows correct msg");
//    }
//
//    @Test
//    public void alertBoxMsgAfterAcceptTest() {
//        String msg = "Anton";
//
//        javascriptAlertBoxDemo = new JavascriptAlertBoxDemo(driver);
//        driver.get(ConfProperties.getProperty("javascriptAlertBoxDemo"));
//        javascriptAlertBoxDemo.clickJavaScriptAlertBoxBtn();
//
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        Alert alert = driver.switchTo().alert();
//        alert.sendKeys(msg);
//        alert.accept();
//
//        assertEquals("You have entered '" + msg + "' !", javascriptAlertBoxDemo.getJavaScriptAlertBoxMsg(),
//                "Alert box shows correct msg");
//    }
//}
