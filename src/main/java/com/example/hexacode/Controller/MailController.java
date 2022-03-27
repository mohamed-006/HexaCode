package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Entity.Quiz;
import tn.esprit.hexacode.Repository.UserRepository;
import tn.esprit.hexacode.Service.quizzQuestionService;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController

public class MailController {
    
    @Autowired
    public JavaMailSender emailSender;



    @Autowired
    UserRepository userRepository;
    @Autowired
    quizzQuestionService quizzQuestionService;

    @ResponseBody
    @RequestMapping("/sendSimpleEmail")
    public String sendSimpleEmail(@RequestBody Quiz question ) throws MessagingException {

        User user = new User();

        MimeMessage mimeMessage = emailSender.createMimeMessage();

        // Create a Simple MailMessage.
        SimpleMailMessage message = new SimpleMailMessage();

        boolean multipart = true;

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, multipart, "utf-8");

        String htmlMsg = "<h3>Im testing send a HTML email</h3>"
                +"<img src='http://www.apache.org/images/asf_logo_wide.gif'>";


        // Create a Simple MailMessage.
        //SimpleMailMessage message = new SimpleMailMessage();

        //message.setTo(MyConstants.FRIEND_EMAIL);
        message.setSubject("about your quiz");
        message.setTo(user.getEmail());
        message.setText("Quizz Time !!! Show us your ability ");

        mimeMessage.setContent(htmlMsg, "text/html");

        helper.setTo(user.getEmail());

        helper.setSubject("Event Pass");

        // Send Message!
        this.emailSender.send(message);
        quizzQuestionService.addQuizzQuestion(question);

        return "Email Sent!";
    }
}
