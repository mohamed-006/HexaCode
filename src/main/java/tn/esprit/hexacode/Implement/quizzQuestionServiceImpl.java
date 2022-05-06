package tn.esprit.hexacode.Implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Entity.Quiz;
import tn.esprit.hexacode.Repository.LevelRepository;
import tn.esprit.hexacode.Repository.quizzQuestionRepository;
import tn.esprit.hexacode.Service.quizzQuestionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class quizzQuestionServiceImpl implements quizzQuestionService {

    private JavaMailSender mailSender;
    public void setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Autowired
    quizzQuestionRepository questionRepository;
    @Autowired
    LevelRepository levelRepository;
    @Override
    public Quiz addQuizzQuestion(Quiz question, Long idLevel) {

        Level level = levelRepository.findById(idLevel).orElse(null);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long idQuestion) {

         questionRepository.deleteById(idQuestion);
    }

    @Override
    public Quiz updateQuestion(Quiz question) {
        return questionRepository.save(question);
    }

    @Override
    public Quiz addQuizzQuestion(Quiz question) {

        return questionRepository.save(question);
    }

    @Override
    public boolean equals(String CorrectAnswer, String Answer) {

        return CorrectAnswer.toLowerCase().contains(Answer);
    }

    @Override
    public List<User> findAllEmails() {
        return questionRepository.findAllEmails();
    }

}