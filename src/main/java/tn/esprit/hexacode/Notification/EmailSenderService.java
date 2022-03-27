package tn.esprit.hexacode.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailSenderService {
    @Autowired
    private JavaMailSender mailSender;

//    public void sendSimpleEmail(String toEmail,
//                                String body,
//                                String Subject) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("mohamedali.boucetta@esprit.tn");
//        message.setTo(toEmail);
//        message.setText(body);
//        message.setSubject(Subject);
//
//        mailSender.send(message);
//        System.out.println("Mail Send...");
//    }
    public void sendEmailWithAttachement(String toEmail,
                                         String body,
                                         String Subject,
                                         String attachement) throws MessagingException{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
        mimeMessageHelper.setFrom("mohamedali.boucetta@esprit.tn");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText(body);
        mimeMessageHelper.setSubject(Subject);

        FileSystemResource fileSystem = new FileSystemResource(new File(attachement));

        mimeMessageHelper.addAttachment(fileSystem.getFilename(),fileSystem);

        mailSender.send(mimeMessage);
        System.out.println("Mail Send with attachement...");

    }
}
