package com.example.hexacode.repository;

import com.example.hexacode.Entity.Article;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Query( value="select * from Article order by  date_de_publication",nativeQuery=true)
    List<Article> retrieveArticleDateNaissanceIntervalle();

    @Query(value="select count(*) from article where article_id_id",nativeQuery=true)
    boolean NbreInteractionBypub(@Param("article_id_id") Article article_id_id);

    @Transactional
    @Modifying
    @Query(value="delete from article_comment where article_comment.article_id_id",nativeQuery=true)
    void DeleteCommentsByPub(@Param("article_id_id") Article article_id_id);

    //  Article findAll(Sort id);

    @Query(value="select  title from article",nativeQuery=true)
    List<String> findpubtxt();
}
