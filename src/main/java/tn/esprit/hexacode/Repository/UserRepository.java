package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.User;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<String> findUserByEtatIsTrue();

//    @Query(value = "select u.email from User u where u.etat=TRUE ")
//    List<User> findAllMail();
}