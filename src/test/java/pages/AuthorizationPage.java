package pages;

import model.Credentials;

import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage
{
    public static void login(Credentials credentials) {
        $("#mailbox__login").setValue(credentials.getLogin());
        $("#mailbox__login__domain").selectOptionContainingText(credentials.getEmailDomain());
        $("#mailbox__password").setValue(credentials.getPass());
        $("#mailbox__auth__button").click();
    }
}
