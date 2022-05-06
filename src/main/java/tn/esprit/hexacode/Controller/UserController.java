package tn.esprit.hexacode.Controller;

import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Service.UserService;

import javax.transaction.Transactional;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public User CreateUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    @CrossOrigin(origins = "http://localhost:4200")
    public void DeleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
    }
    @RequestMapping(value = "/getallEmails",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public List<String> findAllEmails(){
        return userService.findAllEmails();
    }

    @RequestMapping(value = "/getallEmailsByEtat",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public List<String> findUserByEtatIsTrue(){
        return userService.findUserByEtatIsTrue();
    }

    @RequestMapping(value = "/findallEmail",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    @Transactional
    public List<String> findAllMail(){

        return userService.findAllMail();
    }
}
