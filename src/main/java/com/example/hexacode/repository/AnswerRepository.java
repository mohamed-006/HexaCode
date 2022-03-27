package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Answer;
@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}