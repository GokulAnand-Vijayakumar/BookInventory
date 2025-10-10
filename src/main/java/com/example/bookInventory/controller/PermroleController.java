package com.example.bookInventory.controller;

import com.example.bookInventory.entity.Permrole;
import com.example.bookInventory.service.PermroleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permrole")
public class PermroleController {

    @Autowired
    private PermroleService permroleService;

    // GET all permroles
    @GetMapping("/all")
    public ResponseEntity<List<Permrole>> getAllPermroles() {
        return ResponseEntity.ok(permroleService.getAllPermroles());
    }

    // GET permrole by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPermroleById(@PathVariable Long id) {
        Permrole role = permroleService.getPermroleById(id);
        if (role != null) {
            return ResponseEntity.ok(role);
        } else {
            return ResponseEntity.status(404).body("Permrole not found");
        }
    }

    // POST add new permrole
    @PostMapping("/add")
    public ResponseEntity<?> addPermrole(@RequestBody Permrole permrole) {
        String result = permroleService.addPermrole(permrole);
        if ("POSTSUCCESS".equals(result)) {
            return ResponseEntity.ok("Permrole added successfully");
        } else {
            return ResponseEntity.badRequest().body("Permrole already exists");
        }
    }

    // PUT update permrole by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePermrole(@PathVariable Long id, @RequestBody Permrole updatedPermrole) {
        Permrole role = permroleService.updatePermrole(id, updatedPermrole);
        if (role != null) {
            return ResponseEntity.ok("Permrole updated successfully");
        } else {
            return ResponseEntity.status(404).body("Permrole not found");
        }
    }
}