package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.Question;
import tn.esprit.hexacode.Service.QuestionService;

import java.util.List;

@RestController
public class QuestionController {


    @Autowired
    QuestionService questionService;

//    @RequestMapping(value = { "/countValidQuestionsInQuiz/{id}" }, method = RequestMethod.GET)
//    public Long countValidQuestionsInQuiz(@PathVariable("id") Long idQuiz) {
//        return questionService.countQuestionByIsvalid(idQuiz);
//    }

    @RequestMapping(value = { "/deleteQuestion/{id}" }, method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteQuestion(@PathVariable Long idQuestion){
        questionService.deleteQuestion(idQuestion);
    }
    @RequestMapping(value = { "/updateQuestion/{id}" }, method = RequestMethod.PUT)
    @CrossOrigin(origins = "http://localhost:4200")
    public String update(Question question){
        return questionService.update(question);
    }
//    @PostMapping("/addQuestion/{idLevel}")
//    @CrossOrigin(origins = "http://localhost:4200")
//    Question addQuestion(@RequestBody Question question, @PathVariable("idLevel") Long idLevel) {
//        return questionService.addQuestion(question, idLevel);
//    }
    @GetMapping("/getQuestions/{idLevel}")
    @CrossOrigin(origins = "http://localhost:4200")
    List<Question> getQuestions(@PathVariable("idLevel") Long idLevel)  {
        return questionService.getQuestions(idLevel);
    }
    @RequestMapping(value = { "/getAll" }, method = RequestMethod.GET)
    public List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @PostMapping("/addQuestion/{idLevel}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Question ajouterEtAffecterQuestionLevel(@RequestBody Question question, @PathVariable Long idLevel){
        return questionService.ajouterEtAffecterQuestionLevel(question,idLevel);
    }
}
