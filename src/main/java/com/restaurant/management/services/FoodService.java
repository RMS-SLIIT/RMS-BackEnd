package com.restaurant.management.services;

import java.util.List;
import com.restaurant.management.dto.FoodSearchDto;
import com.restaurant.management.entities.Food;

public interface FoodService {

	public boolean isFoodIdExists(Long id);

	public void saveFood(Food food);

	public List<Food> getAllFood();

	public Food getFoodById(Long id);

	public String deleteFoodById(Long id);

	public void updateFood(Food food);

	public List<Food> multipulSearchFood(FoodSearchDto foodSearchDto);
}
