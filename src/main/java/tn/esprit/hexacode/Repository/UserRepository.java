package tn.esprit.hexacode.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tn.esprit.hexacode.Entity.User;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}