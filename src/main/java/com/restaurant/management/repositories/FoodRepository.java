package com.restaurant.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import com.restaurant.management.entities.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>, QuerydslPredicateExecutor<Food> {

}
