package utils;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.io.Files;
import io.qameta.allure.Attachment;

import java.io.File;
import java.io.IOException;

public class Attachments {
    @Attachment(value = "{attachName}")
    public static byte[] takeScreenshot(String attachName) throws IOException {
        File screenshot = Screenshots.takeScreenShotAsFile();
        return Files.toByteArray(screenshot);
    }

    @Attachment(value = "PageSource", type = "text/html")
    public static String takeCurrentPageHTML() {
        return WebDriverRunner.source();
    }
}
