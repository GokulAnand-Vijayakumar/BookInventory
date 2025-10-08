package com.example.bookInventory.service;

import java.util.List;

import com.example.bookInventory.entity.Permrole;

public interface PermroleService {
    Permrole save(Permrole obj);
    Permrole getById(Long id);
    List<Permrole> getAll();
    void deleteById(Long id);
}
