package com.restaurant.management.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.management.dto.FoodDto;
import com.restaurant.management.dto.FoodSearchDto;
import com.restaurant.management.entities.Food;
import com.restaurant.management.mapper.Mapper;
import com.restaurant.management.services.FoodService;
import com.restaurant.management.util.Constants;
import com.restaurant.management.util.EndPointURI;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FoodController {
	@Autowired
	private Mapper mapper;
	@Autowired
	private FoodService foodService;

	@PostMapping(value = EndPointURI.FOOD)
	public ResponseEntity<Object> addFood(@Valid @RequestBody FoodDto foodDto) {
		foodService.saveFood(mapper.map(foodDto, Food.class));
		return new ResponseEntity<>(Constants.ADD_FOOD_SUCCESS, HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.FOOD)
	public ResponseEntity<Object> getAllFood() {
		return new ResponseEntity<Object>(mapper.map(foodService.getAllFood(), FoodDto.class), HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.FOOD_SEARCH)
	public ResponseEntity<Object> searchFood(FoodSearchDto foodSearchDto) {
		return new ResponseEntity<>(mapper.map(foodService.multipulSearchFood(foodSearchDto), Food.class),
				HttpStatus.OK);
	}

	@GetMapping(value = EndPointURI.FOOD_BY_ID)
	public ResponseEntity<Object> getFoodById(@PathVariable Long id) {
		if (foodService.isFoodIdExists(id)) {
			return new ResponseEntity<>(mapper.map(foodService.getFoodById(id), FoodDto.class), HttpStatus.OK);
		}
		return new ResponseEntity<>(Constants.FOOD, HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping(value = EndPointURI.FOOD_BY_ID)
	public ResponseEntity<Object> deleteFoodById(@PathVariable Long id) {
		if (!foodService.isFoodIdExists(id)) {
			return new ResponseEntity<>(Constants.FOOD, HttpStatus.BAD_REQUEST);
		}
		foodService.deleteFoodById(id);
		return new ResponseEntity<Object>(Constants.DELETE_FOOD_SUCCESS, HttpStatus.OK);
	}

	@PutMapping(value = EndPointURI.FOOD)
	public ResponseEntity<Object> editFood(@Valid @RequestBody FoodDto foodDto) {
		if (!foodService.isFoodIdExists(foodDto.getId())) {
			return new ResponseEntity<>(Constants.FOOD, HttpStatus.BAD_REQUEST);
		}

		foodService.updateFood(mapper.map(foodDto, Food.class));
		return new ResponseEntity<>(Constants.EDIT_FOOD_SUCCESS, HttpStatus.OK);
	}
}
