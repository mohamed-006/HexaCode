package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.Level;
@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {
}