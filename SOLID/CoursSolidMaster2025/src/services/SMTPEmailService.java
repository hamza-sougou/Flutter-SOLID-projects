package services;

public class SMTPEmailService implements EmailService {
    @Override
    public void sendEmail(String recipient, String message) {
        System.out.println("Email envoyé à " + recipient);
    }
}