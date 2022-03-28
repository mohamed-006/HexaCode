package com.example.hexacode.repository;

import com.example.hexacode.Entity.Article_Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository  extends CrudRepository<Article_Comment, Long> {
}
