package com.knapsack.project;

import com.knapsack.project.Knapsack.GreedyKnapsack;
import com.knapsack.project.Knapsack.MultidimensionalKnapsack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnapsackService {

    GreedyKnapsack greedyKnapsack = new GreedyKnapsack();
    MultidimensionalKnapsack multidimensionalKnapsack = new MultidimensionalKnapsack();

    public List<MealNutritionFacts> knapsack(List<MealNutritionFacts> meals,
                                             String algorithmType,
                                             Double calories,
                                             String macro,
                                             Integer protein,
                                             Integer fat,
                                             Integer carbs){
        if("".equals(macro)){
            return multidimensionalKnapsack.knapsack(meals, calories, protein,fat,carbs);
        }else{
            return greedyKnapsack.knapsack(meals, calories, macro);
        }
    }
}
