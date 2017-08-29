package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InboxPage
{
    @Step("Use searchbox to find email by text \"{searchText}\"")
    public InboxPage findEmail(String searchText) {
        $("#portal-menu__search__form").$("input").setValue(searchText).pressEnter();
        return this;
    }

    @Step("List of visible emails should have size \"{numbers}\"")
    public InboxPage shouldBeEmails(int numbers) {
        $$(byClassName("b-datalist__item__body")).filter(visible).shouldHaveSize(numbers);
        return this;
    }

    @Step("Open email by index \"{index}\"")
    public EmailPage openEmailByIndex(int index) {
        $$(byClassName("b-datalist__item__body")).filter(visible).get(index).$("a").click();
        return new EmailPage();
    }
}
