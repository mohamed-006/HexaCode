package com.example.hexacode.service;

import com.example.hexacode.Entity.Badge;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.BadgeRepository;
import com.example.hexacode.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class BadgeServiceImpl implements BadgeService {
    private final UserRepository userRepo;
    private final BadgeRepository badgeRepo;
    @Override
    public Badge addBadge(Badge badge) {
        return badgeRepo.save(badge);
    }

    @Override
    public void addBadgeToUser(String username) {
        User user = userRepo.findByUsername(username) ;
        List<Badge> badgeList = badgeRepo.findAll();
        for (Badge badge : badgeList) {
            if(user.getPoints() <=badge.getMaxpoints() && user.getPoints() >=badge.getMinpoints()){
                user.setBadge(badge);
        }
        }
    }
}
