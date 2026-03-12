package com.zholdigaliev.foodlist.Controller;

import com.zholdigaliev.foodlist.Entity.Food;
import com.zholdigaliev.foodlist.Repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class FoodListController {
    private final FoodRepository foodRepository;


    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("foods", foodRepository.findAll());
        return "main";
    }

    @PostMapping("/add-food")
    public String addFood(Food food) {
        foodRepository.save(food);
        return "redirect:/";
    }

    @PostMapping("/update-food")
    public String updateFood(Food food) {
        foodRepository.save(food);
        return "redirect:/";
    }

    @PostMapping("/delete-food")
    public String deleteFood(@RequestParam int id) {
        foodRepository.deleteById(id);
        return "redirect:/";
    }
}
