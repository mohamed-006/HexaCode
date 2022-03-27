package tn.esprit.hexacode.Service;

import tn.esprit.hexacode.Entity.User;

import java.util.Collection;
import java.util.List;

public interface UserService {


    void DeleteUser(Long id);

    Collection<User> findAllEmails();

    User CreateUser(User user);
}
