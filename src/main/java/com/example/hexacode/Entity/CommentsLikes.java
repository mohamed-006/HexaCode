package com.example.hexacode.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentsLikes implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private boolean isLiked;

    @Enumerated(EnumType.STRING)
    private TypeOfLikes Likes;


    @ManyToOne
    User user ;

    @ManyToOne
    Article_Comment article_comment ;
}
