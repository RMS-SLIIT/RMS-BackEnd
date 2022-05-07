package com.restaurant.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurant.management.entities.Inventory;
import com.restaurant.management.repositories.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Transactional
	public void saveInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

	@Transactional
	public void editInventory(Inventory inventory) {
		inventoryRepository.save(inventory);
	}

	@Transactional(readOnly = true)
	public List<Inventory> getInventoryDetails() {
		return inventoryRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Inventory getInventoryDetailsById(Long id) {
		return inventoryRepository.findById(id).get();
	}

	@Transactional
	public String deleteInventoryDetails(Long id) {
		inventoryRepository.deleteById(id);
		return "Inventory Detail Removed !! " + id;
	}

	@Override
	public boolean isInventoryIdExists(Long id) {
		return inventoryRepository.existsById(id);
	}

}
