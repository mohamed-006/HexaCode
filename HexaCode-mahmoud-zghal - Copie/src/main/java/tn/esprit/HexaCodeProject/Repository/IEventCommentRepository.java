package tn.esprit.HexaCodeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.HexaCodeProject.Entity.EventComment;
@Repository
public interface IEventCommentRepository extends JpaRepository<EventComment, Long> {

}
