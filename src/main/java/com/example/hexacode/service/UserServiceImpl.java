package com.example.hexacode.service;

import com.example.hexacode.Entity.Role;
import com.example.hexacode.Entity.User;
import com.example.hexacode.repository.UserRepository;
import com.example.hexacode.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername (username);
        if(user == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", username);
        }
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getName()));
            });

            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities) ;
        }
    @Override
    public User saveUser(User user) {
        log.info("Saving new user {} to database",user.getName());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public User updateUser(User user) {
        log.info("Updating  user {} to database",user.getName());
        return userRepo.save(user);
    }
    public void deleteUser(String username) {
        User user = userRepo.findByUsername(username) ;
        log.info("deleting  user {} from database",user.getName());
        userRepo.delete(user);
    }

    @Override
    public Collection<Role> getRoles(String username) {

            User user = userRepo.findByUsername(username);
            return user.getRoles() ;

    }


    @Override
    public User getUser(String username) {
        log.info("fetching user {} ",username);

        return userRepo.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to database",role.getName());

        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("adding role {} to user {}",roleName,username);

        User user = userRepo.findByUsername(username);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
    }



}
