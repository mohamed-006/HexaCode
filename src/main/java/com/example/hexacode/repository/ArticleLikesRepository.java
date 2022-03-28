package com.example.hexacode.repository;

import com.example.hexacode.Entity.Article_Likes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ArticleLikesRepository extends CrudRepository<Article_Likes,Long> {

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'like' ",nativeQuery=true)
    long LikesArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'love' ",nativeQuery=true)
    long LoveArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'angry' ",nativeQuery=true)
    long AngryArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'haha'",nativeQuery=true)
    long HahaArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'sad'",nativeQuery=true)
    long SadArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'solidarity'",nativeQuery=true)
    long SolidarityArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);

    @Query(value="select count(*) from article_likes l where l.articles_id= :articles_id and l.users_id_user= :users_id_user and react = 'wow'",nativeQuery=true)
    long WowArticle(@Param("articles_id") long articles_id , @Param("users_id_user") long users_id_user);
}
