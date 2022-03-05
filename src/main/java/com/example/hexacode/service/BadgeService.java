package com.example.hexacode.service;

import com.example.hexacode.Entity.Badge;

public interface BadgeService {
    Badge addBadge(Badge badge) ;
    void addBadgeToUser(String username);
}
