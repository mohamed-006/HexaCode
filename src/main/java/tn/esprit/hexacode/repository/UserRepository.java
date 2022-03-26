package tn.esprit.hexacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.hexacode.Entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
