package com.example.hexacode.service;

import com.example.hexacode.Entity.CommentsLikes;
import com.example.hexacode.Entity.TypeOfLikes;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.CommentsRepository;
import com.example.hexacode.repository.LikeRepository;
import com.example.hexacode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesService  implements ILikes{

    @Autowired
    private LikeRepository likeRepo;

    @Autowired
    private CommentsRepository comm;

    @Autowired
    private UserRepository userr;


    public  void  ajouterEtAffecterlikesCommentaires(CommentsLikes ac, long user_id_user, long article_comment_id ){

        Iterable<User> user = userr.findAll();
        for (User user2 : user) {

            if (likeRepo.LikeComment(user_id_user,article_comment_id )==0){
                if(user2.getId() == user_id_user){
                    comm.findById(article_comment_id ).map(c -> {
                        ac.setLikes(TypeOfLikes.Like);
                        ac.setArticle_comment(c);
                        ac.setUser(user2);
                        ac.setLiked(true);
                        return c ;
                    } );
                    likeRepo.save(ac);
                }
            }
        }
    }
    public  void  ajouterEtAffecterDislikesCommentaires(CommentsLikes ac, long user_id_user, long article_comment_id ){
        Iterable<User> user = userr.findAll();
        for (User user2 : user) {

            if (likeRepo.DislikeComment(user_id_user,article_comment_id )==0){
                if(user2.getId() == user_id_user){
                    comm.findById(article_comment_id ).map(c -> {
                        ac.setLikes(TypeOfLikes.Dislike);
                        ac.setArticle_comment(c);
                        ac.setUser(user2);
                        ac.setLiked(true);
                        return c ;
                    } );
                    likeRepo.save(ac);
                }
            }
        }
    }
}
