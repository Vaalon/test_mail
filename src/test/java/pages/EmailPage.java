package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;

public class EmailPage
{
    @Step("Sender email should be equals \"{senderEmail}\"")
    public EmailPage senderEmailShouldBe(String senderEmail) {
        $(byClassName("b-contact-informer-target"))
                .shouldHave(attribute("data-contact-informer-email",
                                        senderEmail));
        return this;
    }

    @Step("Email subject should be \"{subject}\"")
    public EmailPage subjectShouldBe(String subject) {
        $(byClassName("b-letter__head__subj__text")).shouldHave(exactText(subject));
        return this;
    }

    @Step("Email content should have text \"{content}\"")
    public EmailPage contentShouldHave(String content) {
        $(byClassName("b-letter__body__wrap")).shouldHave(text(content));
        return this;
    }

    //TODO: move to base page
    public void logout() {
        $("#PH_logoutLink").click();
    }
}
