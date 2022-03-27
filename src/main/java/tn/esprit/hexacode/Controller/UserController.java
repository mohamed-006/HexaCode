package tn.esprit.hexacode.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Service.UserService;

import javax.transaction.Transactional;
import java.util.Collection;


@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/addUser")
    public User CreateUser(@RequestBody User user) {
        return userService.CreateUser(user);
    }

    @RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
    public void DeleteUser(@PathVariable Long id) {
        userService.DeleteUser(id);
    }
    @RequestMapping(value = "/getallEmails",method = RequestMethod.GET)
    @Transactional
    public Collection<User> findAllEmails(){
        return userService.findAllEmails();
    }
}
