package education.helpers;
import education.actors.Apprenant;
import education.actors.Person;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;
public class emailSender {
    final String user="doufarejawad23@gmail.com";
    final String password="";
    public emailSender(StringBuilder stringBuilder, String email, List<Person> persons){
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.mailtrap.io");
        prop.put("mail.smtp.port", "25");
        prop.put("mail.smtp.ssl.trust", "smtp.mailtrap.io");
        Session session = Session.getDefaultInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,password);
                    }
                });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            for (Person Apprenant: persons) {
                if(Apprenant instanceof Apprenant){
                    if(Apprenant.getEmail().equals(email)){
                        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
                    }
                }

            }
            message.setSubject("Nouveux brief ajouté");
            message.setText(stringBuilder.toString());

            // try to send mail
            Transport.send(message);

        }catch (MessagingException e){
            System.out.println("something went wrong "+ e.getMessage());

        }


    }


}
