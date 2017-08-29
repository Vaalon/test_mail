import com.codeborne.selenide.Configuration;
import io.qameta.allure.Feature;
import model.Credentials;
import model.Email;
import org.testng.annotations.*;
import pages.AuthorizationPage;
import pages.InboxPage;
import utils.ExcelUtils;
import utils.TestFailListener;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;

@Listeners({TestFailListener.class})
public class MailTest
{

    @Parameters({"selenium.browser"})
    @BeforeSuite
    public void setUp(@Optional("firefox") String browser) {
        Configuration.browser = browser;
    }


    @Test(description = "Open email and validate it",
            dataProvider = "mailTestData")
    public void testMail(Credentials credentials, String searchText, Email email) throws Exception {
        clearBrowserCookies();
        open("https://mail.ru");

        AuthorizationPage.login(credentials);

        new InboxPage().findEmail(searchText)
                .shouldBeEmails(1)
                .openEmailByIndex(0)
                
                .senderEmailShouldBe(email.getSenderEmail())
                .subjectShouldBe(email.getSubject())
                .contentShouldHave(email.getContent())
                .logout();
    }

    @DataProvider(name = "mailTestData")
    public static Object[][] mailTestData() throws IOException {
        ExcelUtils sheet = new ExcelUtils("./src/test/resources/mailTestData.xlsx",
                "mailTestData");

        Object[][] mailTestData = new Object[sheet.getLastRowNum()][];

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            mailTestData[i] = new Object[] {
                    new Credentials(sheet.getCellData(i+1, 0),
                                    sheet.getCellData(i+1, 1),
                                    sheet.getCellData(i+1, 2)),

                    sheet.getCellData(i+1, 3),

                    new Email(sheet.getCellData(i+1, 4),
                                sheet.getCellData(i+1, 5),
                                sheet.getCellData(i+1, 6))
            };
        }

        return mailTestData;
    }
}
