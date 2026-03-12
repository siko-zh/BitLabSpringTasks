package com.zholdigaliev.foodlist.Repository;

import com.zholdigaliev.foodlist.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
