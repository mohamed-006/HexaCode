package com.example.hexacode.repository;


import com.example.hexacode.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByName(String name) ;
}
