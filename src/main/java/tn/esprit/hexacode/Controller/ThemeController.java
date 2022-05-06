package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.Theme;
import tn.esprit.hexacode.Repository.ThemeRepository;
import tn.esprit.hexacode.Service.ThemeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ThemeController {
    @Autowired
    ThemeService themeService;
    @PostMapping("/addTheme")
    @CrossOrigin(origins = "http://localhost:4200")
    public Theme addTheme(@RequestBody Theme theme) {
        return themeService.addTheme(theme);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/getThemes")
    public List<Theme> getThemes() {
        return themeService.getThemes();
    }
    @GetMapping("/deleteTheme/{idTheme}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteTheme(@PathVariable Long idTheme){
        themeService.deleteTheme(idTheme);
    }

}
