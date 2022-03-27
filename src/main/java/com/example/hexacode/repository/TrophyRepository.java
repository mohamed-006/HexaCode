package com.example.hexacode.repository;

import com.example.hexacode.Entity.Category;
import com.example.hexacode.Entity.Trophy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrophyRepository extends JpaRepository<Trophy, Long> {

    List<Trophy> findAllBycategory(Category category);
}