package tn.esprit.hexacode.Implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.OrikaBeanMapper;
import tn.esprit.hexacode.Entity.Question;
import tn.esprit.hexacode.Repository.LevelRepository;
import tn.esprit.hexacode.Repository.QuestionRepository;
import tn.esprit.hexacode.Service.QuestionService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    LevelRepository levelRepository;
    @Autowired
    OrikaBeanMapper orikaBeanMapper;
    @Autowired
    QuestionService questionService;

    @Override
    public Question addQuestion(Question question){
        return questionRepository.save(question);
    }

    @Override
    public Question addQuestion(Question question, Level level) {

        level.addQuestion(question);
        return questionRepository.save(question);
    }

    @Override
    @Transactional
    public String update(Question question) {
        String msg="";
        Boolean Exists = questionRepository.existsById(question.getId());
        if(Exists){
            questionRepository.update(question.getId(),question.getQuestion(), question.getResponse1(), question.getResponse2(), question.getResponse3(), question.getCorrect());
            msg = "question updated.";
        }else
            msg = "question not found.";
        return msg;
    }
    /*
    @Override
	@Transactional
	public void ajouterEtAffecterClientBoutiques(Client client, List<Long> idBoutiques) {
		clientrepository.save(client);
		List<Boutique> boutiques = boutiqueRepository.findAll();
		for (Boutique boutique : boutiques) {
			for (Long id : idBoutiques) {
				if (boutique.getId()==(id)) {
					boutique.getClients().add(client);
					clientrepository.save(client);
				}
			}
		}
	}
	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {

		Rayon rayon = rayonRepository.findById(idRayon).orElse(null);
		Stock stock = stockRepository.findById(idStock).orElse(null);

		p.setRayon(rayon);
		p.setStock(stock);


		return produitRepository.save(p);

	}
     */

    @Override
    @Transactional
    public Question ajouterEtAffecterQuestionLevel(Question question, Long idLevel) {
        Level level = levelRepository.findById(idLevel).orElse(null);
        question.setLevel(level);
        return questionRepository.save(question);
    }

    @Override
    public void deleteQuestion(Long idQuestion) {
        questionRepository.deleteById(idQuestion);
    }

    @Override
    public Question addQuestion(Question question, Long idLevel) {
        return null;
    }

    @Override
    public List<Question> getQuestions(Long idLevel) {
        Level level = levelRepository.findById(idLevel).orElse(null);
        return questionRepository.findByLevel(level);
    }

    @Override
    public List<Question> getQuestions() {
        return  questionRepository.findAll();
    }

}
