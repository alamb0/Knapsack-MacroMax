package com.knapsack.project.Knapsack;

import com.knapsack.project.MealNutritionFacts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GreedyKnapsack{

    public List<MealNutritionFacts> knapsack(List<MealNutritionFacts> meals, Double totalCalories, String macro){

        //sort meals by macro
        switch (macro){
            case "Protein":
                meals.sort(Comparator.comparing(MealNutritionFacts::getProtein).reversed());
                break;
            case "Fat":
                meals.sort(Comparator.comparing(MealNutritionFacts::getTotalFat).reversed());
                break;
            case "Carbohydrate":
                meals.sort(Comparator.comparing(MealNutritionFacts::getTotalCarbohydrate).reversed());
                break;
        }

        //add to results
        List<MealNutritionFacts> results = new ArrayList<>();

        int caloriesInMeal = 0;
        for(int i = 0; i < meals.size(); i++){
            //add most maximal meal as long as calories don't exceed totalCalories
            if(Double.parseDouble(meals.get(i).getCalories()) <= totalCalories && caloriesInMeal <= totalCalories ){
                if(caloriesInMeal+Double.parseDouble(meals.get(i).getCalories()) <= totalCalories){
                    results.add(meals.get(i));
                    caloriesInMeal += Double.parseDouble(meals.get(i).getCalories());
                }
            }
        }

        return results;
    }
}
