package com.example.hexacode.service;

import com.example.hexacode.Entity.Badge;
import com.example.hexacode.Entity.Category;
import com.example.hexacode.Entity.Trophy;

public interface TrophyService {
    Trophy addTrophy(Trophy trophy) ;
    Trophy editTrophy(Trophy trophy) ;

    String deleteTrophy(Long id  ) ;
    void addTrophyToUser(String username, Category category);
}
