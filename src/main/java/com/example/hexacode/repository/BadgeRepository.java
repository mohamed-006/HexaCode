package com.example.hexacode.repository;

import com.example.hexacode.Entity.Badge;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BadgeRepository extends JpaRepository<Badge,Long> {
}
