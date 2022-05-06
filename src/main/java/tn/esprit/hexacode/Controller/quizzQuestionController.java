package tn.esprit.hexacode.Controller;

import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Entity.Quiz;
import tn.esprit.hexacode.Repository.UserRepository;
import tn.esprit.hexacode.Repository.quizzQuestionRepository;
import tn.esprit.hexacode.Service.UserService;
import tn.esprit.hexacode.Service.quizzQuestionService;

import javax.mail.internet.InternetAddress;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class quizzQuestionController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Autowired
    private JavaMailSender mailSender;


    @Autowired
    quizzQuestionService quizzQuestionService;

    @Autowired
    quizzQuestionRepository questionRepository;

    @RequestMapping(value = { "/allEmail" }, method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<User> findAllEmails(){
        return quizzQuestionService.findAllEmails();
    }

    @RequestMapping(value = { "/allquizz" }, method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Quiz> viewEmployees(Model model) {

         List<Quiz> allQuizz = questionRepository.findAll();
        //model.addAttribute("quizz", allQuizz);

        return questionRepository.findAll();

    }

    @PostMapping("addquizz")
    @CrossOrigin(origins = "http://localhost:4200")
    public Quiz addQuizzQuestion(@RequestBody Quiz question, User user) throws MailException {


        MimeMessagePreparator preparator =  mimeMessage -> {
            String[] to =  userService.findAllEmails().toArray(new String[0]);

            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);
            message.setTo((to));
            message.setFrom("mohamedali.boucetta@esprit.tn"); // could be parameterized...

            message.setText("<h2>your quiz</h1> ", true);
        };
       mailSender.send(preparator);
        return quizzQuestionService.addQuizzQuestion(question);
    }

    @PostMapping("addquizz/{idLevel}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Quiz addQuizzQuestion(@RequestBody Quiz question, @PathVariable Long idLevel){
        return quizzQuestionService.addQuizzQuestion(question,idLevel);
    }

    @DeleteMapping("deleteQuestion/{idQuestion}")
    @CrossOrigin(origins = "http://localhost:4200")
    void delete(@PathVariable Long idQuestion){
        quizzQuestionService.deleteQuestion(idQuestion);
    }
    @PutMapping("updateQuestion")
    @CrossOrigin(origins = "http://localhost:4200")
    public Quiz updateQuestion(@RequestBody Quiz question){
        return quizzQuestionService.updateQuestion(question);
    }

    @PostMapping("findDiffIndexes/{CorrectAnswer}/{answer}")
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean findDiffIndexes(@PathVariable String CorrectAnswer, @PathVariable  String answer ){
        return quizzQuestionService.equals(CorrectAnswer,answer);
    }
}
