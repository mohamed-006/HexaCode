package tn.esprit.hexacode.Service;

import tn.esprit.hexacode.Entity.User;

import java.util.List;

public interface UserService {


    void DeleteUser(Long id);

    List<String> findAllEmails();
    List<String> findUserByEtatIsTrue();

    User CreateUser(User user);
    List<String> findAllMail();
}
