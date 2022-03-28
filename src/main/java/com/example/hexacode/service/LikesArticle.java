package com.example.hexacode.service;

import com.example.hexacode.Entity.Article_Likes;
import com.example.hexacode.Entity.ReactARTICLE;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.ArticleLikesRepository;
import com.example.hexacode.repository.ArticleRepository;
import com.example.hexacode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesArticle  implements ILikesArticle{
    @Autowired
    private UserRepository userr;
    @Autowired
    private ArticleRepository articlee;
    @Autowired
    private ArticleLikesRepository likesRepository;




    public void AddLikesArticle(Article_Likes like_ar, long users_id_user , long articles_id) {

        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if(likesRepository.LikesArticle(users_id_user ,articles_id)==0){
                if(user2.getId()==users_id_user){
                    articlee.findById(articles_id).map(c ->{
                        like_ar.setReact(ReactARTICLE.like);
                        like_ar.setArticles(c);
                        like_ar.setUsers(user2);
                        like_ar.setClic_like(true);
                        return c;
                    });
                    likesRepository.save(like_ar);
                }

            }

        }

    }
    public  void AddLoveArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if(likesRepository.LoveArticle(users_id_user ,articles_id)==0){
                if(user2.getId()==users_id_user){
                    articlee.findById(articles_id).map(c->{
                        likes.setReact(ReactARTICLE.love);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    });
                    likesRepository.save(likes);

                }
            }
        }
    }

    public  void AddAngryArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if(likesRepository.AngryArticle(users_id_user,articles_id)==0){
                if(user2.getId()==users_id_user){
                    articlee.findById(articles_id).map(c ->{
                        likes.setReact(ReactARTICLE.angry);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    });
                    likesRepository.save(likes);
                }
            }
        }
    }
    public  void AddHahaArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if (likesRepository.HahaArticle(users_id_user , articles_id)==0){
                if(user2.getId() == users_id_user){
                    articlee.findById(articles_id).map(c-> {
                        likes.setReact(ReactARTICLE.haha);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    });
                    likesRepository.save(likes);
                }
            }
        }
    }
    public  void AddSadArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if (likesRepository.SadArticle(users_id_user,articles_id)==0){
                if(user2.getId() == users_id_user){
                    articlee.findById(articles_id).map(c -> {
                        likes.setReact(ReactARTICLE.sad);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    } );
                    likesRepository.save(likes);
                }
            }
        }
    }
    public  void AddSolidarityArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if (likesRepository.SolidarityArticle(users_id_user,articles_id)==0){
                if(user2.getId() == users_id_user){
                    articlee.findById(articles_id).map(c -> {
                        likes.setReact(ReactARTICLE.solidarity);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    } );
                    likesRepository.save(likes);
                }
            }
        }
    }
    public  void AddWowArticles(Article_Likes likes , long users_id_user , long articles_id){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {
            if (likesRepository.WowArticle(users_id_user,articles_id)==0){
                if(user2.getId() == users_id_user){
                    articlee.findById(articles_id).map(c -> {
                        likes.setReact(ReactARTICLE.wow);
                        likes.setArticles(c);
                        likes.setUsers(user2);
                        likes.setClic_like(true);
                        return c ;
                    } );
                    likesRepository.save(likes);
                }
            }
        }
    }
}
