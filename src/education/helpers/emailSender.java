package education.helpers;
import education.actors.Apprenant;
import education.actors.Person;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.List;
import java.util.Properties;
public class emailSender {
    final String username ="doufarejawad23@gmail.com";
    final String password="qzyjwnfcegmeprqd";


    public emailSender(StringBuilder stringBuilder, String email, List<Person> persons) throws MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("doufarejawad23@gmail.com", password);
            }
        });
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("doufarejawad23@gmail.com"));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse("jdoufare2001@gmail.com"));
        message.setSubject("Mail Subject");

        String msg = stringBuilder.toString();

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }


}
