package model;

public class Credentials
{
    private final String login;

    private final String emailDomain;

    private final String pass;

    public Credentials(String login, String emailDomain, String pass) {
        this.login = login;
        this.emailDomain = emailDomain;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getEmailDomain() {
        return emailDomain;
    }

    public String getPass() {
        return pass;
    }
}
