package uz.javatuz.mailing;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

public class MailingExample {
    public static void main(String[] args) throws MessagingException, IOException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");

        String username = "guvalakat1603@gmail.com";
        String password = "eysbnpqdqjsjqqlv";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("Yaxshi xabar");
//        message.setText("Xabar keldi G52 dan...");
//        message.setContent("<h1 style=\"color: red;\">Html message qabul qilindi</h1>","text/html");


        String messageEmail = """
                <div>
                    <h1 style="color: red;">Html message qabul qilindi</h1>
                    <img src="cid:image1" width="500"/>
                </div>
                """;

        // HTML content with embedded image
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(messageEmail, "text/html");

        // Attach image
        MimeBodyPart imagePart = new MimeBodyPart();
        imagePart.attachFile("D:\\life rool.jpg");
        imagePart.setContentID("<image1>");

        // Create Multipart
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(htmlPart);
        multipart.addBodyPart(imagePart);

        message.setContent(multipart);

        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("devatpdp@gmail.com"));

        Transport.send(message);
        System.out.println("xabar junatildi.............");



    }
}
