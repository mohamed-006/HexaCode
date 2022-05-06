package tn.esprit.hexacode.Service;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.Question;

import java.util.List;

@Service
public interface QuestionService {

    Question addQuestion (Question question);
    //Long countQuestionByQuizAndIsvalidIsTrue(Long idQuiz);
   // Long countQuestionByIsvalid(Long idQuiz);

    Question addQuestion (Question question, Level level);

    String update(Question question);
    //void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques);
 Question ajouterEtAffecterQuestionLevel(Question question, Long idLevel);
    //Long countQuestionByIsvalid(Long idQuiz);

    void deleteQuestion (Long idQuestion);

    Question addQuestion(Question question, Long idLevel);

    List<Question> getQuestions(Long idLevel);
    public List<Question> getQuestions();
}
