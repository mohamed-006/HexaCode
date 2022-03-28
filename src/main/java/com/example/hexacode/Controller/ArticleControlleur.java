package com.example.hexacode.Controller;

import com.example.hexacode.Entity.*;
import com.example.hexacode.service.IArticle;
import com.example.hexacode.service.IComments;
import com.example.hexacode.service.ILikes;
import com.example.hexacode.service.ILikesArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feed")
public class ArticleControlleur {
    @Autowired
    private IArticle article ;
    @Autowired
    private IComments commarticle;
    @Autowired
    private ILikes ilikes ;
    @Autowired
    private ILikesArticle iLikesArticle;



    @GetMapping("/retrieveArticle/{id}")
    public Article retrieveArticleById(@PathVariable("id") int id){
        return article.retrieveArticleById(id);
    }

    @GetMapping("/retrieveAllArticle")
    public List<Article> retrieveArticleById(){
        return article.retrieveAllArticle();
    }

    @PutMapping("/updateArticle")
    public Article updateArticle(@RequestBody Article a ){
        return article.updateArticle(a);
    }

    @DeleteMapping("/delete-Article/{id}")
    public void  deleteArticle (@PathVariable("id") long id){
        article.deleteArticleById(id);
    }

    @PostMapping("/add-article/{idDepartement}")
    public Article ajouterEtaffecterListearticle(@RequestBody Article la, @PathVariable("idDepartement") long idDepartement){
        return  article.ajouterEtaffecterListearticle(la, idDepartement);
    }

    @GetMapping("/retrieveArticleOfTheYear")
    public List<Article> getAllArticleOfThisYear(){
        return article.getAllArticleOfThisYear();
    }

    @DeleteMapping("/DeletePubWithoutInteraction")
    public void DeletePostsWithoutInteraction(){
        article.DeletePostsWithoutInteraction();
    }

    @GetMapping("/AlaUne")
    public List<Article> AffichageDesSujetsAlaUne(){
        return article.AffichageDesSujetsAlaUne();
    }

    @GetMapping("/User")
    public List<Article_Comment> MeilleurUser(){
        return commarticle.MeilleurUser();
    }

    @PostMapping("/addArticle")
    public Article addArticle (@RequestBody Article a) {
        return  article.addArticle(a);
    }

    @PostMapping("AddLikesArticle/{userId}/{comId}")
    public void AddLikesArticle(@PathVariable("userId")long users_id_user,@PathVariable("comId")long articles_id,@RequestBody Article_Likes like_ar) {
        iLikesArticle.AddLikesArticle(like_ar, users_id_user, articles_id);
    }

    @PostMapping("/addCommentArticle/{iduser}/{idArticle}")
    public Article_Comment addArticleComment(@RequestBody Article_Comment ac,@PathVariable("iduser") long id, @PathVariable("idArticle")long idd){

        return commarticle.addArticleComment(ac, id , idd);
    }

    @PostMapping("/AddLoveArticle/{userId}/{comAr}")
    public  void AddLoveArticles(@RequestBody Article_Likes likes , @PathVariable("userId")long users_id_user , @PathVariable("comAr")long articles_id){
        iLikesArticle.AddLoveArticles(likes , users_id_user,articles_id);
    }

    @PostMapping("/AddANgryArticle/{userId}/{comAr}")
    public  void AddAngryArticles(@RequestBody Article_Likes likes , @PathVariable("userId")long users_id_user , @PathVariable("comAr")long articles_id){
        iLikesArticle.AddAngryArticles (likes , users_id_user,articles_id);
    }

    @PostMapping("/AddHahaArticle/{userId}/{comAr}")
    public  void AddHahaArticles(@RequestBody Article_Likes likes , @PathVariable("userId") long users_id_user , @PathVariable("comAr") long articles_id){
        iLikesArticle.AddHahaArticles(likes , users_id_user,articles_id);
    }

    @PostMapping("/AddSadArticle/{userId}/{comAr}")
    public  void AddSadArticles(@RequestBody Article_Likes likes , @PathVariable("userId") long users_id_user ,@PathVariable("comAr") long articles_id){
        iLikesArticle.AddSadArticles(likes,users_id_user , articles_id);
    }

    @PostMapping("/AddSolidarityArticle/{userId}/{comAr}")
    public  void AddSolidarityArticles(@RequestBody Article_Likes likes , @PathVariable("userId") long users_id_user , @PathVariable("comAr") long articles_id){
        iLikesArticle.AddSolidarityArticles(likes,users_id_user,articles_id);
    }

    @PostMapping("/AddWowArticle/{userId}/{comAr}")
    public  void AddWowArticles(@RequestBody Article_Likes likes ,@PathVariable("userId")  long users_id_user , @PathVariable("comAr") long articles_id){
        iLikesArticle.AddWowArticles(likes,users_id_user,articles_id);
    }

    @PostMapping("/AddLikeComment/{userId}/{comID}")
    public  void  ajouterEtAffecterlikesCommentaires(@RequestBody  CommentsLikes ac,@PathVariable("userId") long user_id_user, @PathVariable("comID") long article_comment_id ){
        ilikes.ajouterEtAffecterlikesCommentaires(ac , user_id_user,article_comment_id);
    }

    @PostMapping("/AddDisLikeComment/{userId}/{comID}")
    public  void  ajouterEtAffecterDislikesCommentaires(@RequestBody CommentsLikes ac, @PathVariable("userId") long user_id_user, @PathVariable("comID") long article_comment_id ){
        ilikes.ajouterEtAffecterDislikesCommentaires(ac , user_id_user , article_comment_id);
    }
}
