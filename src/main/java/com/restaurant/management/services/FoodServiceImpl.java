package com.restaurant.management.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.querydsl.core.BooleanBuilder;
import com.restaurant.management.dto.FoodSearchDto;
import com.restaurant.management.entities.Food;
import com.restaurant.management.entities.QFood;
import com.restaurant.management.repositories.FoodRepository;
import com.restaurant.management.util.Utils;

@Service
public class FoodServiceImpl implements FoodService {

	@Autowired
	private FoodRepository foodRepository;

	@Override
	public boolean isFoodIdExists(Long id) {
		return foodRepository.existsById(id);
	}

	@Override
	public void saveFood(Food food) {
		foodRepository.save(food);

	}

	@Override
	public List<Food> getAllFood() {

		return foodRepository.findAll();
	}

	@Override
	public Food getFoodById(Long id) {

		return foodRepository.findById(id).get();
	}

	@Override
	public String deleteFoodById(Long id) {

		foodRepository.deleteById(id);
		return "Food Detail Removed !! " + id;
	}

	@Override
	public void updateFood(Food food) {
		foodRepository.save(food);

	}

	@Override
	public List<Food> multipulSearchFood(FoodSearchDto foodSearchDto) {
		BooleanBuilder booleanBuilder = new BooleanBuilder();
		if (Utils.isNotNullAndEmpty(foodSearchDto.getFoodName())) {
			booleanBuilder.and(QFood.food.foodName.containsIgnoreCase(foodSearchDto.getFoodName()));
		}

		return (List<Food>) foodRepository.findAll(booleanBuilder);
	}

}
