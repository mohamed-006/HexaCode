package com.example.hexacode.service;

import com.example.hexacode.Entity.Role;
import com.example.hexacode.Entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
    User updateUser(User user);
    void deleteUser(String username);
}
