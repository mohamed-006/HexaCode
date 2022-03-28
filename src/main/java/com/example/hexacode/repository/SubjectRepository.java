package tn.esprit.hexacode.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.hexacode.Entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
