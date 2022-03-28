package com.example.hexacode.service;

import com.example.hexacode.Entity.CommentsLikes;

public interface ILikes {
    public  void  ajouterEtAffecterlikesCommentaires(CommentsLikes ac, long user_id_user, long article_comment_id ) ;
    public  void  ajouterEtAffecterDislikesCommentaires(CommentsLikes ac, long user_id_user, long article_comment_id ) ;

}
