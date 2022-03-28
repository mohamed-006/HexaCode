package com.example.hexacode.repository;

import com.example.hexacode.Entity.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepository extends CrudRepository<Messages, Long > {
}
