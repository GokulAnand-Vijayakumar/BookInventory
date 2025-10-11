package com.example.bookInventory.controller;

import com.example.bookInventory.entity.UserDet;
import com.example.bookInventory.service.UserDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/user")
public class UserDetController {

    @Autowired
    private UserDetService userDetService;

    // 1. Get all users
    @GetMapping
    public ResponseEntity<List<UserDet>> getAllUsers() {
        return ResponseEntity.ok(userDetService.getAllUsers());
    }

    // 2. Add new user
    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> addUser(@RequestBody UserDet userDet) {
        UserDet existingUser = userDetService.getUserById(userDet.getUserId());
        Map<String, String> response = new HashMap<>();

        if (existingUser == null) {
            userDetService.addUser(userDet);
            response.put("code", "POSTSUCCESS");
            response.put("message", "User added successfully");
            return ResponseEntity.ok(response);
        } else {
            response.put("code", "ADDFAILS");
            response.put("message", "User already exist");
            return ResponseEntity.status(409).body(response);
        }
    }

    // 3. Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Integer userId) {
        UserDet user = userDetService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "NOTFOUND",
                "message", "User not found"
            ));
        }
    }

    // 4. Update phone number
    @PutMapping("/update/phonenumber/{userId}")
    public ResponseEntity<?> updatePhoneNumber(@PathVariable Integer userId, @RequestBody String phoneNumber) {
        UserDet updated = userDetService.updatePhoneNumber(userId, phoneNumber);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "UPDATEFAILS",
                "message", "User not found"
            ));
        }
    }

    // 5. Update first name
    @PutMapping("/update/firstname/{userId}")
    public ResponseEntity<?> updateFirstName(@PathVariable Integer userId, @RequestBody String firstName) {
        UserDet updated = userDetService.updateFirstName(userId, firstName);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "UPDATEFAILS",
                "message", "User not found"
            ));
        }
    }

    // 6. Update last name
    @PutMapping("/update/lastname/{userId}")
    public ResponseEntity<?> updateLastName(@PathVariable Integer userId, @RequestBody String lastName) {
        UserDet updated = userDetService.updateLastName(userId, lastName);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.status(404).body(Map.of(
                "code", "UPDATEFAILS",
                "message", "User not found"
            ));
        }
    }
}