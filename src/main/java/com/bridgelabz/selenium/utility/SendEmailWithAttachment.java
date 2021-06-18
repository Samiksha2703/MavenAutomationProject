/**
 * purpose : To send email in project
 * Author : Samiksha Shende
 * Date : 05/06/2021
 */

package com.bridgelabz.selenium.utility;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendEmailWithAttachment {

    public static void main(String[] args) {

        // Create object of Property file
        Properties props = new Properties();

        // this will set host of server- you can change based on your requirement
        props.put("mail.smtp.host", "smtp.gmail.com");

        // set the port of socket factory
        props.put("mail.smtp.socketFactory.port", "465");

        // set socket factory
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        // set the authentication to true
        props.put("mail.smtp.auth", "true");

        // set the port of SMTP server
        props.put("mail.smtp.port", "465");

        // This will handle the complete authentication
        Session session = Session.getDefaultInstance(props,

                new javax.mail.Authenticator() {

                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication("samiksha@yahoo.com", "Samiksha");
                    }
                });

        try {

            // Create object of MimeMessage class
            Message message = new MimeMessage(session);

            // Set the from address
            message.setFrom(new InternetAddress("samiksha@yahoo.com"));

            // Set the recipient address
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("tushar@rediffmail.com"));

            // Add the subject link
            message.setSubject("Testing Subject");

            // Create object to add multimedia type content
            BodyPart messageBodyPart1 = new MimeBodyPart();

            // Set the body of email
            messageBodyPart1.setText("This is message body");

            // Create another object to add another content
            MimeBodyPart messageBodyPart2 = new MimeBodyPart();

            // Mention the file which you want to send
            String filename = "emailable-report.html";

            File att = new File(new File("C:\\Users\\kalam\\IdeaProjects\\MavenAutomationProject\\test-output"), filename);
            messageBodyPart2.attachFile(att);

            // set the file
            messageBodyPart2.setFileName(filename);

            // Create object of MimeMultipart class
            Multipart multipart = new MimeMultipart();

            // add body part 1
            multipart.addBodyPart(messageBodyPart2);

            // set the content
            message.setContent(multipart);

            // finally send the email
            Transport.send(message);

            System.out.println("=====Email Sent=====");

        } catch (MessagingException | IOException e) {

            throw new RuntimeException(e);
        }

    }
}
