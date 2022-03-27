package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Entity.Quiz;

import java.util.List;


@Repository
public interface quizzQuestionRepository extends JpaRepository<Quiz,Long> {

    @Query(
            value = "SELECT * FROM User ",
            nativeQuery = true)
    List<User> findAllEmails();



}
