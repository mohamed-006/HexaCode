package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.History;


@Repository
public interface HistoryRepository extends JpaRepository<History, Long> {
    History findHistoryByScore(Long score);

    History findHistoryByUsername(String username);

}