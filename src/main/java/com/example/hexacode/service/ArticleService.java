package com.example.hexacode.service;

import com.example.hexacode.Entity.Article;
import com.example.hexacode.Entity.Department;
import com.example.hexacode.repository.ArticleRepository;
import com.example.hexacode.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ArticleService implements IArticle{
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    DepartementRepository deprepo ;


    @Override
    public Article addArticle (Article a) {
        return articleRepository.save(a);
    }

    @Override
    public List<Article> retrieveAllArticle() {
        return (List<Article>) articleRepository.findAll();
    }

    public Article retrieveArticleById(int id){
        return articleRepository.findById((long) id).orElse(null);
    }

    @Override
    public Article updateArticle(Article a) {
        return articleRepository.save(a);
    }


    public  void deleteArticleById(Long id){
        articleRepository.deleteById(id);
    }

    @Override
    public Article ajouterEtaffecterListearticle(Article la, long idDepartement) {
        Department dep = deprepo.findById(idDepartement).orElse(null);
        Article articles = (Article) articleRepository.findAll();


        if (articles.getId().equals(la.getId())) {
            System.out.println("la publication exist deja");
        }

        articles.setDepartment2(dep);
        return  articleRepository.save(articles);

    }


    @Override
    public List<Article> getAllArticleOfThisYear() {

        List<Article> articles = (List<Article>) articleRepository.findAll();
        return articleRepository.retrieveArticleDateNaissanceIntervalle();
    }
    @Override
    public List<Article> AffichageDesSujetsAlaUne(){
        List<Article> articles = (List<Article>) articleRepository.findAll();
        Comparator<Article> comp = (x, y) ->y.getArticle_commentSet().size()-x.getArticle_commentSet().size();
        return articles.stream().sorted(comp).collect(Collectors.toList());
    }



    @Override
    public void DeletePostsWithoutInteraction() {
        List<Article> a = (List<Article>) articleRepository.findAll();
        //    List<Publication> p = publicationRep.findAll();
        // for (int i = 0; i < a.size(); i++) {
        //      if (articleRepository.NbreInteractionBypub(a.get(i)) <= 2) {
        //     if (publicationRep.NbreCommentsBypub(p.get(i))<=2 && publicationRep.NbreInteractionBypub(p.get(i))<=2) {
        //   articleRepository.deleteById(a.get(i).getId());
        //    articleRepository.DeleteCommentsByPub(a.get(i));

        //publicationRep.deleteById(p.get(i).getId());
        //  publicationRep.deleteById(p.get(i).getId());


    }//


}
