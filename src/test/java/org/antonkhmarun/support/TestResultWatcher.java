package org.antonkhmarun.support;

import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.antonkhmarun.support.ScreenshotMaker;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

public class TestResultWatcher implements TestWatcher {

    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        saveScreenshot(getDriver(context));
        driverInfo();
        closeDriver(context);
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        closeDriver(context);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        closeDriver(context);
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        closeDriver(context);
    }

    @SneakyThrows
    private WebDriver getDriver(ExtensionContext context) {
        Object test = context.getRequiredTestInstance();
        Field field = test.getClass().getSuperclass().getDeclaredField("driver");
        field.setAccessible(true);
        return (WebDriver) field.get(test);
    }

    private void closeDriver(ExtensionContext context) {
        getDriver(context).quit();
    }

    @Attachment(value = "Failed test screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        ScreenshotMaker screenshotMaker = new ScreenshotMaker(driver);
        return screenshotMaker.takeScreenShotAsBytes();
    }

    @Attachment(value = "Driver Info", type = "application/json", fileExtension = ".txt")
    public byte[] driverInfo() throws IOException {
        return Files.readAllBytes(Paths.get("src/test/resources/browserInfo.txt"));
    }
}
