package tn.esprit.hexacode.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Entity.Question;

import java.util.List;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

//    @Query("SELECT count(q.isvalid) from Question q join q.quiz z where z.idQuiz=?1 and (q.isvalid = true)")
//    Long countValidQuestionsByQuizAndIsValidTrue(@Param("idQuiz") Long idQuiz);
    boolean existsById(Long id);

    @Modifying
    @Query("update Question q set q.id= :id, q.question= :question, q.response1= :response1, q.response2= :response2, q.response3= :response3, q.correct= :correct where q.id= :id")
    int update(@Param("id") Long id, @Param("question") String question, @Param("response1") String response1, @Param("response2") String response2, @Param("response3") String response3, @Param("correct") String correct);

    List<Question> findByLevel(Level level);


}