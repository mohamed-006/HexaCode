package com.example.hexacode.service;

import com.example.hexacode.Entity.Badge;

public interface BadgeService {
    Badge addBadge(Badge badge) ;
    Badge editBadge(Badge badge) ;
    String deleteBadge(Long id  ) ;
    void addBadgeToUser(String username);
    //event added nchouf kifeh el particiepr bech tzid les points 
}
