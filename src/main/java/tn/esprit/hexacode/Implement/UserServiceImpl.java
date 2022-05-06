package tn.esprit.hexacode.Implement;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.hexacode.Entity.User;
import tn.esprit.hexacode.Repository.UserRepository;
import tn.esprit.hexacode.Service.UserService;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void DeleteUser(Long id) {

    }

    @Override
    public List<String> findAllEmails() {
        return userRepository.findAll().stream().map(User::getEmail).collect(Collectors.toList());
    }

    @Override
    public List<String> findUserByEtatIsTrue() {
        //return userRepository.findAll().stream().filter().map(e->e.isEtat(boolean::true) && e.getEmail()).collect(Collectors.toList());


        //return userRepository.findAll().filter(e->e.isEtat()==true).map(e->e.getEmail()).collect(Collectors.toList());
        return userRepository.findAll().stream().filter(e-> e.isEtat()).map(e->e.getEmail()).collect(Collectors.toList());
    }

    @Override
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<String> findAllMail() {
        //return userRepository.findAll().stream().map(e->e.getEmail()).collect(Collectors.toList());
        return (List<String>) userRepository.findAll().stream().filter(user -> user.isEtat());
    }
}
