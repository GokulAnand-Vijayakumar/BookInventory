package com.example.bookInventory.service.impl;

import com.example.bookInventory.entity.Inventory;
import com.example.bookInventory.exception.ResourceNotFoundException;
import com.example.bookInventory.repository.InventoryRepository;
import com.example.bookInventory.service.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


     public boolean saveInventoryIfNotExists(Inventory inventory) {
    List<Inventory> existing = inventoryRepository.findByIsbn(inventory.getIsbn());
    if (existing.isEmpty()) {
        inventoryRepository.save(inventory);
        return true;
    }
    return false;
    }


    @Override
    public Inventory save(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getByInventoryId(Long inventoryId) {
        return inventoryRepository.findById(inventoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Inventory not found with ID: " + inventoryId));
    }

    @Override
    public List<Inventory> getAll() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory updatePurchasedStatus(Long inventoryId, Integer purchased) {
        Inventory inventory = getByInventoryId(inventoryId);
        inventory.setPurchased(purchased);
        return inventoryRepository.save(inventory);
    }

    @Override
    public void deleteById(Long inventoryId) {
        if (!inventoryRepository.existsById(inventoryId)) {
            throw new ResourceNotFoundException("Inventory not found with ID: " + inventoryId);
        }
        inventoryRepository.deleteById(inventoryId);
    }

	@Override
	public Inventory getById(Long inventoryId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Inventory updatePurchasedStatus(Long inventoryId, Boolean purchased) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Inventory getInventoryById(int i) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Inventory addInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return null;
	}
}