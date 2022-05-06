package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.Level;
import tn.esprit.hexacode.Service.LevelService;

import java.util.List;
import java.util.Set;

@RestController
public class LevelController {


    @Autowired
    LevelService levelService;

    @PostMapping("/addLevel/{idTheme}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Level addLevel(@RequestBody Level level, @PathVariable("idTheme") Long idTheme) {
        return levelService.addLevel(level, idTheme);
    }
    /*
    @GetMapping("/listClient/{idBoutique}")
	@ResponseBody
	List<Client> listedeClients(@PathVariable("idBoutique") Long idBoutique){
		return clientservice.listedeClients(idBoutique);
	}
     */

    @GetMapping("/getLevels/{idTheme}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Level> getLevels(@PathVariable("idTheme") Long idTheme) {
        return levelService.getLevels(idTheme);
    }

    @GetMapping("/getLevel/{idLevel}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Level getLevel(@PathVariable("idLevel") Long idLevel) {
        return levelService.getLevel(idLevel);
    }
}
