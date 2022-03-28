package com.example.hexacode.repository;

import com.example.hexacode.Entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends CrudRepository<Department,Long> {
}
