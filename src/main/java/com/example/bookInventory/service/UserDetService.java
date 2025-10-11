package com.example.bookInventory.service;

import com.example.bookInventory.entity.UserDet;

import java.util.List;

public interface UserDetService {
    List<UserDet> getAllUsers();
    UserDet getUserById(Integer userId);
    UserDet addUser(UserDet userDet);
    UserDet updatePhoneNumber(Integer userId, String phoneNumber);
    UserDet updateFirstName(Integer userId, String firstName);
    UserDet updateLastName(Integer userId, String lastName);
}