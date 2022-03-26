package com.example.hexacode.Controller;

import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.UserRepository;
import com.example.hexacode.service.UserNotFoundException;
import com.example.hexacode.service.UserService;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller @Slf4j
public class ForgotPasswordController {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/forgot_passworddd")
    public String showForgotPasswordForm() {
        return "forgot_password_form";

    }

    @PostMapping("/forgot_password/{id}")
    public String processForgotPassword(@PathVariable Long id ) {
        User user = userRepository.getById(id) ;
        String email = user.getEmail();
        String token = RandomString.make(30);

        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordLink =  "reset_password?token=" + token;
            sendEmail(email, resetPasswordLink);
           // model.addAttribute("message", "We have sent a reset password link to your email. Please check.");

        } catch (UserNotFoundException ex) {
        //    model.addAttribute("error", ex.getMessage());
        } catch (UnsupportedEncodingException | MessagingException e) {
           // model.addAttribute("error", "Error while sending email");
        }

        return "yes";
    }

    public void sendEmail(String recipientEmail, String link)
            throws  UnsupportedEncodingException , MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom("haktiraw@gmail.com", "hexacode ");
        helper.setTo(recipientEmail);

        String subject = "Here's the link to reset your password";

        String content = "<p>Hello,</p>"
                + "<p>You have requested to reset your password.</p>"
                + "<p>Click the link below to change your password:</p>"
                + "<p><a href=\"" + link + "\">Change my password</a></p>"
                + "<br>"
                + "<p>Ignore this email if you do remember your password, "
                + "or you have not made the request.</p>";

        helper.setSubject(subject);

        helper.setText(content, true);

        mailSender.send(message);
    }


    @GetMapping("/reset_password")
    public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("token", token);

        if (user == null) {
            model.addAttribute("message", "Invalid Token");
            return "message";
        }

        return "reset_password_form";
    }

    @PostMapping("/reset_password")
    public String processResetPassword(@RequestParam(name="token") String token ,@RequestBody String password) {

        log.info("intered in resert password ");
        User user = userService.getByResetPasswordToken(token);


        if (user == null) {
            return  "Invalid Token" ;

        } else {
            userService.updatePassword(user, password);
        }
        return "message";
    }
}