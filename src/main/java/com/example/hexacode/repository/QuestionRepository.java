package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query("SELECT count(q.isvalid) from Question q join q.quiz z where z.idQuiz=?1 and (q.isvalid = true)")
    Long countValidQuestionsByQuizAndIsValidTrue(@Param("idQuiz") Long idQuiz);
}