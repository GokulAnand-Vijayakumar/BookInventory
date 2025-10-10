package com.example.bookInventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookInventory.entity.Permrole;

import java.util.Optional;

public interface PermroleRepository extends JpaRepository<Permrole, Long> {
    Optional<Permrole> findByRoleName(String roleName);
    Optional<Permrole> findById(Long id);
}