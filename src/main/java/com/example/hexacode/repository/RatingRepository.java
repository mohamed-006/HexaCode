package tn.esprit.hexacode.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.hexacode.Entity.Rating;
@Repository
public interface RatingRepository extends JpaRepository<Rating , Long>{
	
	@Query("select r from Rating r where r.user.id = :userId and r.collaborator.id = :collabId ")
	public Rating findRatingByUserAndCollaborator(@Param("userId") Long userId,@Param("collabId") Long collabId);
	
	@Query("select r from Rating r where r.collaborator.id = :collabId ")
	public List<Rating> findRatingBycollaborator(@Param("collabId") Long collabId);

}
