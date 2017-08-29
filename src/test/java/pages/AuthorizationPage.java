package pages;

import io.qameta.allure.Step;
import model.Credentials;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage
{
    @Step("Login with credentials: {credentials}")
    public static void login(Credentials credentials) {
        $("#mailbox__login").setValue(credentials.getLogin());
        $("#mailbox__login__domain").selectOptionContainingText(credentials.getEmailDomain());
        $("#mailbox__password").setValue(credentials.getPass());
        $("#mailbox__auth__button").click();
    }
}
