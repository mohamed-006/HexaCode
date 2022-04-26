package tn.esprit.HexaCodeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long>{

}
