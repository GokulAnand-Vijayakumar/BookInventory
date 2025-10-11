package com.example.bookInventory.repository;

import com.example.bookInventory.entity.UserDet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetRepository extends JpaRepository<UserDet, Integer> {
    // Optional: find by username if needed for login or uniqueness check
    UserDet findByUserName(String userName);
}