//package org.antonkhmarun.test;
//
//import org.antonkhmarun.config.ConfProperties;
//import org.antonkhmarun.pageFactory.BootstrapDownloadProgressDemo;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class DownloadingTest extends BaseTest {
//
//    BootstrapDownloadProgressDemo bootstrapDownloadProgressDemo;
//
//    @Test
//    public void downloadingTo50Percent() {
//        bootstrapDownloadProgressDemo = new BootstrapDownloadProgressDemo(driver);
//        driver.get(ConfProperties.getProperty("bootstrapDownloadProgressDemo"));
//        bootstrapDownloadProgressDemo.clickDownloadBtn();
//
//        wait.until((ExpectedCondition<Boolean>) driver -> bootstrapDownloadProgressDemo.isPercentageGreaterOrEqual50());
//
//        driver.navigate().refresh();
//        assertEquals(bootstrapDownloadProgressDemo.getDownloadedPercent(), 0);
//    }
//}
