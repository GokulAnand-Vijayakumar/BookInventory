package com.example.bookInventory.service.impl;


import com.example.bookInventory.entity.Permrole;
import com.example.bookInventory.repository.PermroleRepository;
import com.example.bookInventory.service.PermroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermroleServiceImpl implements PermroleService {

    @Autowired
    private PermroleRepository permroleRepository;

    @Override
    public List<Permrole> getAllPermroles() {
        return permroleRepository.findAll();
    }

    @Override
    public Permrole getPermroleById(Long id) {
        return permroleRepository.findById(id).orElse(null);
    }

    @Override
    public String addPermrole(Permrole permrole) {
        if (permroleRepository.findByRoleName(permrole.getRoleName()).isPresent()) {
            return "ADDFAILS";
        }
        permroleRepository.save(permrole);
        return "POSTSUCCESS";
    }

    @Override
    public Permrole updatePermrole(Long id, Permrole updatedPermrole) {
        Optional<Permrole> existing = permroleRepository.findById(id);
        if (existing.isPresent()) {
            Permrole role = existing.get();
            role.setRoleName(updatedPermrole.getRoleName());
            role.setDescription(updatedPermrole.getDescription());
            return permroleRepository.save(role);
        }
        return null;
    }
}
