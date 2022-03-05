package com.example.hexacode.repository;

import com.example.hexacode.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username) ;
}
