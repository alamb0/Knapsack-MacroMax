package com.knapsack.project;

import com.knapsack.project.CSVLoader.CSVLoaderService;
import com.knapsack.project.NutrionixAPI.NutrionixUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Spring Controller that handles routes
 *
 */
@Controller
public class KnapsackController {

    @Autowired
    KnapsackService knapsackService;

    @Autowired
    CSVLoaderService csvLoaderService;

    @Autowired
    NutrionixUtil nutrionixUtil;

    @GetMapping("/")
    public String get(Model model){

        return "index";
    }

    @GetMapping("/results")
    public String getResults(@RequestParam(defaultValue = "") String macro,
                             @RequestParam(defaultValue = "0") Integer protein,
                             @RequestParam(defaultValue = "0") Integer fat,
                             @RequestParam(defaultValue = "0") Integer carbs,
                             @RequestParam Double calories,
                             @RequestParam String algorithmType,
                             @RequestParam String customSearch,
                             Model model){

        //decide what meals to load - load from csv if no search term
        List<MealNutritionFacts> meals = csvLoaderService.loadAndStoreMealsFromCSV();
        if(!"".equals(customSearch)){
            //send custom search term to nutritionix API and convert response to meals
           meals = nutrionixUtil.postNutritionix(customSearch);
        }

        //evaluate run time
        double startExecutionTime = System.nanoTime();
        List<MealNutritionFacts> results = knapsackService.knapsack(meals, algorithmType, calories, macro, protein, fat, carbs);
        double endExecutionTime = System.nanoTime();
        double totalExecutionTimeInMilliseconds = (endExecutionTime - startExecutionTime) / 1000000;

        model.addAttribute("knapsackResults", results);
        model.addAttribute("totalCalories", calories);
        model.addAttribute("algorithmType", algorithmType);
        model.addAttribute("executionTime", totalExecutionTimeInMilliseconds);
        model.addAttribute("macro", macro);
        return "results";
    }

    @GetMapping("/meals")
    public String getMeals(@RequestParam(defaultValue = "usda") String diet, Model model){

        //load all meals
        List<MealNutritionFacts> meals = csvLoaderService.loadAndStoreMealsFromCSV();

        model.addAttribute("meals", meals.toArray());
        return "meals";
    }

}
