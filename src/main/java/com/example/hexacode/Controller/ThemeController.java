package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.ThemeRepository;
import tn.esprit.hexacode.Service.ThemeService;

@RestController
public class ThemeController {
    @Autowired
    ThemeService themeService;
//    @Autowired
//    ThemeRepository themeRepository;

    @PostMapping("/addTheme")
    public Theme addTheme(@RequestBody Theme theme){
        return themeService.addTheme(theme);
    }
    @DeleteMapping("deleteTheme/{idTheme}")
    public void deleteTheme(@PathVariable Long idTheme){
        themeService.deleteTheme(idTheme);
    }
}
