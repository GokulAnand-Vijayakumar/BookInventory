
package com.example.bookInventory.service;

import com.example.bookInventory.entity.Inventory;
import java.util.List;

public interface InventoryService {
    Inventory save(Inventory inventory);
    Inventory getByInventoryId(Long inventoryId);
    List<Inventory> getAll();
    Inventory updatePurchasedStatus(Long inventoryId, Boolean purchased);
    void deleteById(Long inventoryId);
    boolean saveInventoryIfNotExists(Inventory inventory);
	Inventory getById(Long inventoryId);
	Inventory getInventoryById(int i);
	Inventory addInventory(Inventory inventory);
	Inventory updatePurchasedStatus(Long inventoryId, Integer purchased);
  
}
