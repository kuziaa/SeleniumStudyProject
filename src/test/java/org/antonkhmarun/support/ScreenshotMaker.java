package org.antonkhmarun.support;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenshotMaker {

    public WebDriver driver;

    public ScreenshotMaker(WebDriver driver) {
        this.driver = driver;
    }

    public void takeScreenShotAsFile(String filePath) throws IOException {
        TakesScreenshot scrShot =((TakesScreenshot) driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(filePath);
        FileUtils.copyFile(SrcFile, DestFile);
    }

    public byte[] takeScreenShotAsBytes() {
        TakesScreenshot scrShot =((TakesScreenshot) driver);
        return scrShot.getScreenshotAs(OutputType.BYTES);
    }

    public String prepareFilePath(String fileName) {
        String basePath = "src/test/resources/screenshots/";
        Date now = new Date();
        return basePath + fileName + "_" + now.getTime() + ".png";
    }
}
