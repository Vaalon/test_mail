package pages;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class EmailPage
{
    public EmailPage senderEmailShouldBe(String senderEmail) {
        $(byClassName("b-contact-informer-target"))
                .shouldHave(attribute("data-contact-informer-email",
                                        senderEmail));
        return this;
    }

    public EmailPage subjectShouldBe(String subject) {
        $(byClassName("b-letter__head__subj__text")).shouldHave(exactText(subject));
        return this;
    }

    public EmailPage contentShouldHave(String content) {
        $(byClassName("b-letter__body__wrap")).shouldHave(text(content));
        return this;
    }

    public void logout() {
        $("#PH_logoutLink").click();
    }
}
