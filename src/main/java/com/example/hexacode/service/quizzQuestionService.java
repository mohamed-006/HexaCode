package tn.esprit.hexacode.Service;

import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Entity.Quiz;

import java.util.List;

@Service
public interface quizzQuestionService {
    Quiz addQuizzQuestion(Quiz question, Long  idLevel);
    void deleteQuestion(Long idQuestion);
    public Quiz updateQuestion(Quiz question);
    Quiz addQuizzQuestion(Quiz question);
    public  boolean equals(String CorrectAnswer, String Answer);
    public List<User> findAllEmails();
}
