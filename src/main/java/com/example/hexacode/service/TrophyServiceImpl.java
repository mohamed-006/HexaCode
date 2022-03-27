package com.example.hexacode.service;

import com.example.hexacode.Entity.Category;
import com.example.hexacode.Entity.Trophy;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.TrophyRepository;
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
public class TrophyServiceImpl implements TrophyService{
   private final TrophyRepository trophyRepository;
    private final UserRepository userRepo;
    @Override
    public Trophy addTrophy(Trophy trophy) {
        return trophyRepository.save(trophy) ;
    }

    @Override
    public Trophy editTrophy(Trophy trophy) {
        return trophyRepository.save(trophy) ;
    }

    @Override
    public String deleteTrophy(Long id) {
       Trophy trophy =trophyRepository.findById(id).orElse(null) ;
        if (trophy!=null){
            trophyRepository.delete(trophy);
            return ("trophy deleted") ;
        }
        else
            return ("trophy not found") ;

    }

    @Override
    public void addTrophyToUser(String username, Category category) {
        User user = userRepo.findByUsername(username) ;
        List<Trophy> trophyList = trophyRepository.findAllBycategory(category) ;
        log.info("found trophies of category : {} ",category);
        switch (category.toString()){

            case ("SPORT"):

                for(Trophy trophy : trophyList){
                    if(user.getSport_points()>=trophy.getMinpoints()){
                        user.getTrophies().add(trophy);
                    }
                }
            case ("CULTURAL"):

                for(Trophy trophy : trophyList){
                    if(user.getCultural_points()>=trophy.getMinpoints()){
                        user.getTrophies().add(trophy);
                    }
                }
            case ("ARTS")    :

                for(Trophy trophy : trophyList){
                    if(user.getArt_points()>=trophy.getMinpoints()){
                        user.getTrophies().add(trophy);
                    }
                }
            case ("PROFESSIONAL")    :

                for(Trophy trophy : trophyList){
                    if(user.getProfessionel_points()>=trophy.getMinpoints()){
                        user.getTrophies().add(trophy);
                    }
                }

            }
        }


    //replace category with the event id then get it's category
    }
    //this method is called when a user participates in a an event

