package model;

public class Email
{
    private final String senderEmail;

    private final String subject;

    private final String content;

    public Email(String sender, String subject, String content) {
        this.senderEmail = sender;
        this.subject = subject;
        this.content = content;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "senderEmail='" + senderEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
