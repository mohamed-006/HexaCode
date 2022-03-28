package com.example.hexacode.service;

import com.example.hexacode.Entity.Article;

import java.util.List;

public interface IArticle {
    Article addArticle (Article a);
    Article retrieveArticleById(int id);
    Article updateArticle(Article a);
    void deleteArticleById(Long id);
    Article ajouterEtaffecterListearticle(Article la, long idDepartement);
    void DeletePostsWithoutInteraction();
    List<Article> getAllArticleOfThisYear();
    List<Article> retrieveAllArticle();
    List<Article> AffichageDesSujetsAlaUne();
}
