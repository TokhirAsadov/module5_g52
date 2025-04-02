package uz.javatuz.mailing;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.Properties;

public class MailingMailtapExample {
    public static void main(String[] args) throws MessagingException, IOException {

        Properties properties = new Properties();
        properties.put("mail.smtp.host","smtp.mailtrap.io");
        properties.put("mail.smtp.port","587");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.auth","true");

        String username = "3d1534369de68b";
        String password = "55717aa1f4a51c";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

        Message message = new MimeMessage(session);
        message.setSubject("Yaxshi xabar");
//        message.setText("Xabar keldi G52 dan...");
        String messageEmail = """
                <div>
                    <h1 style=color: red;>Html message qabul qilindi</h1>
                    <img src=\"data: image/jpg; base64,%s\" width=500/>
                </div>
                """.formatted(getImageAtBase64());
        message.setContent(messageEmail,"text/html");

//        Multipart multipart = new MimeMultipart();
//
//        BodyPart attachment = new MimeBodyPart();
//        attachment.setFileName("G52 Journal.txt");
//        DataSource dataSource = new FileDataSource("g52.txt");
//        DataHandler dataHandler = new DataHandler(dataSource);
//        attachment.setDataHandler(dataHandler);
//
//        BodyPart attachment2 = new MimeBodyPart();
//        attachment2.setFileName("Simples.txt");
//        DataSource dataSource2 = new FileDataSource("simples.txt");
//        DataHandler dataHandler2 = new DataHandler(dataSource2);
//        attachment2.setDataHandler(dataHandler2);
//
//        BodyPart contextMessage = new MimeBodyPart();
//        contextMessage.setContent("<h1 style=\"color: green;\">Attachment is sent</h1>","text/html");
//
//        multipart.addBodyPart(attachment);
//        multipart.addBodyPart(attachment2);
//        multipart.addBodyPart(contextMessage);
//
//        message.setContent(multipart);

        message.setFrom(new InternetAddress("guvalakat1603@gmail.com"));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress("devatpdp@gmail.com"));

        Transport.send(message);
        System.out.println("xabar junatildi.............");



    }

    private static String getImageAtBase64() throws IOException {
        Base64.Encoder encoder = Base64.getEncoder();
        Path path = Path.of("D:\\life rool.jpg");
        byte[] bytes = Files.readAllBytes(path);
        return encoder.encodeToString(bytes);
    }
}
