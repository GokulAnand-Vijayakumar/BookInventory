package com.example.bookInventory.service;
import java.util.List;

import com.example.bookInventory.entity.Permrole;

public interface PermroleService {
    List<Permrole> getAllPermroles();
    Permrole getPermroleById(Long id);
    String addPermrole(Permrole permrole);
    Permrole updatePermrole(Long id, Permrole updatedPermrole);
}