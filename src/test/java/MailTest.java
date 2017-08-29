import com.codeborne.selenide.Configuration;
import model.Credentials;
import model.Email;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.EmailPage;
import pages.InboxPage;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;

public class MailTest
{

    @Parameters({ "selenium.browser" })
    @BeforeSuite
    public void setUp(String browser) {
        Configuration.browser = browser;
    }

    @Test(dataProvider = "mailTestData")
    public void testMail(Credentials credentials, String searchText, Email email) {
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
