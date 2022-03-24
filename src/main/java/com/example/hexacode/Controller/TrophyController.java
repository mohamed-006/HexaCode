package com.example.hexacode.Controller;

import com.example.hexacode.Entity.Badge;
import com.example.hexacode.Entity.Category;
import com.example.hexacode.Entity.Trophy;
import com.example.hexacode.service.TrophyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trophy")
@RequiredArgsConstructor
@Slf4j
public class TrophyController {
    private final TrophyService trophyService;
    @PostMapping("/save")
    public Trophy saveBadge(@RequestBody Trophy trophy){
        return trophyService.addTrophy(trophy);
    }
    @PostMapping("/edit")
    public Trophy editBadge(@RequestBody Trophy trophy){
        return trophyService.editTrophy(trophy);
    }

    @PostMapping("/addTrophyToUser/{username}/{category}")
    public void addTrophyToUser(@PathVariable String username,@PathVariable Category category){
       trophyService.addTrophyToUser(username,category);
    }
}
