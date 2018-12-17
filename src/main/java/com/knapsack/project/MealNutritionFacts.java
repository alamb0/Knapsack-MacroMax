package com.knapsack.project;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MealNutritionFacts{
    String brand;
    String mealName;
    String servingSizeUnit;
    String servingsPerContainer;
    String servingSize;
    String calories;
    String caloriesFromFat;
    String totalFat;
    String saturatedFat;
    String polyunsaturatedFat;
    String monounsaturatedFat;
    String transFat;
    String cholesterol;
    String sodium;
    String potassium;
    String totalCarbohydrate;
    String dietaryFiber;
    String totalSugars;
    String protein;
}
