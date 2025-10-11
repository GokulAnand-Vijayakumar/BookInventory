package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.UserDet;
import com.example.bookInventory.repository.UserDetRepository;
import com.example.bookInventory.service.UserDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetServiceImpl implements UserDetService {

    @Autowired
    private UserDetRepository userDetRepository;

    @Override
    public List<UserDet> getAllUsers() {
        return userDetRepository.findAll();
    }

    @Override
    public UserDet getUserById(Integer userId) {
        return userDetRepository.findById(userId).orElse(null);
    }

    @Override
    public UserDet addUser(UserDet userDet) {
        return userDetRepository.save(userDet);
    }

    @Override
    public UserDet updatePhoneNumber(Integer userId, String phoneNumber) {
        UserDet user = userDetRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setPhoneNumber(phoneNumber);
            return userDetRepository.save(user);
        }
        return null;
    }

    @Override
    public UserDet updateFirstName(Integer userId, String firstName) {
        UserDet user = userDetRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setFirstName(firstName);
            return userDetRepository.save(user);
        }
        return null;
    }

    @Override
    public UserDet updateLastName(Integer userId, String lastName) {
        UserDet user = userDetRepository.findById(userId).orElse(null);
        if (user != null) {
            user.setLastName(lastName);
            return userDetRepository.save(user);
        }
        return null;
    }
}