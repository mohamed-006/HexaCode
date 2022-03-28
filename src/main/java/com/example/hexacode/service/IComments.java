package com.example.hexacode.service;

import com.example.hexacode.Entity.Article_Comment;

import java.util.List;

public interface IComments {
    public Article_Comment addArticleComment(Article_Comment ac, long id, long idd) ;
    public List<Article_Comment> MeilleurUser();
}
