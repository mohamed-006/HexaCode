package com.example.hexacode.service;

import com.example.hexacode.Entity.Article_Likes;

public interface ILikesArticle {
    public void AddLikesArticle(Article_Likes like_ar, long users_id_user , long articles_id);
    public  void AddLoveArticles(Article_Likes likes , long users_id_user , long articles_id);
    public  void AddAngryArticles(Article_Likes likes , long users_id_user , long articles_id);
    public  void AddHahaArticles(Article_Likes likes , long users_id_user , long articles_id);
    public  void AddSadArticles(Article_Likes likes , long users_id_user , long articles_id);
    public  void AddSolidarityArticles(Article_Likes likes , long users_id_user , long articles_id);
    public  void AddWowArticles(Article_Likes likes , long users_id_user , long articles_id);
}


