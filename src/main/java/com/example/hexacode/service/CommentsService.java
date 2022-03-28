package com.example.hexacode.service;

import com.example.hexacode.Entity.Article;
import com.example.hexacode.Entity.Article_Comment;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.ArticleRepository;
import com.example.hexacode.repository.CommentsRepository;
import com.example.hexacode.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService implements IComments{

    @Autowired
    private CommentsRepository comm ;
    @Autowired
    private UserRepository userr ;
    @Autowired
    private ArticleRepository articlee ;

    public Article_Comment addArticleComment(Article_Comment ac, long id, long idd) {

        User user = userr.findById(id).orElse(null);
        Article article = articlee.findById(idd).orElse(null);
        ac.setArticle(article);
        //ac.setAuthor(article);
        ac.setUser(user);
        ac.setClic_comment(true);
        return comm.save(ac);

    }
    @Override
    public List<Article_Comment> MeilleurUser(){
        List<Article_Comment> article_comments = (List<Article_Comment>) comm.findAll();
        Comparator<Article_Comment> comparator = (x, y) -> (int) (y.getUser().getId().longValue()-x.getUser().getId().longValue());
        return article_comments.stream().sorted(comparator).collect(Collectors.toList());
    }

}
