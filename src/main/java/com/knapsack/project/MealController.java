package com.knapsack.project;

import com.knapsack.project.CSVLoader.CSVLoaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    CSVLoaderService csvLoaderService;

    @GetMapping("/getMeals")
    public List<MealNutritionFacts> getMeals(){

        return csvLoaderService.loadAndStoreMealsFromCSV();
    }

}
