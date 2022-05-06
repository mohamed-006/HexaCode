package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.History;
import tn.esprit.hexacode.Service.HistoryService;

import java.util.List;


@RestController
public class HistoryController {
    @Autowired
    HistoryService historyService;
    @GetMapping("/findHistoryByUsername/{username}")
    @CrossOrigin(origins = "http://localhost:4200")
    History findHistoryByUsername(@PathVariable("username") String username){
        return historyService.findHistoryByUsername(username);
    }
    @PostMapping("/addHistory")
    @CrossOrigin(origins = "http://localhost:4200")
    History addHistory(@RequestBody History history){
        return historyService.addHistory(history);
    }
    @PutMapping("/editHistory/{username}")
    @CrossOrigin(origins = "http://localhost:4200")
    History editHistory(@RequestBody History history, @PathVariable("username") String username){
        return historyService.editHistory(history,username);
    }
    @GetMapping("/getHistories")
    @CrossOrigin(origins = "http://localhost:4200")
    List<History> getHistories(){
        return historyService.getHistories();
    }
    @GetMapping("/findHistoryBySore/{score}")
    @CrossOrigin(origins = "http://localhost:4200")
    History findHistoryByScore(@PathVariable("score") Long score){
        return historyService.findHistoryByScore(score);
    }



}
