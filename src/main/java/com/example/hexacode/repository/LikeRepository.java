package com.example.hexacode.repository;

import com.example.hexacode.Entity.CommentsLikes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends CrudRepository<CommentsLikes,Long> {

    @Query(value="select count(*) from comments_likes l where l.article_comment_id= :article_comment_id and l.user_id_user= :user_id_user and likes = 'like'",nativeQuery=true)
    long LikeComment(@Param("article_comment_id") long article_id , @Param("user_id_user") long user_id_user);

    @Query(value="select count(*) from comments_likes l where l.article_comment_id= :article_comment_id and l.user_id_user= :user_id_user and likes = 'dislike'",nativeQuery=true)
    long DislikeComment(@Param("article_comment_id") long article_id , @Param("user_id_user") long user_id_user);
}
