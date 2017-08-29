package utils;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class TestFailListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult tr) {
        try {
            Attachments.takeScreenshot("PageScreenshot.png");
            Attachments.takeCurrentPageHTML();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
