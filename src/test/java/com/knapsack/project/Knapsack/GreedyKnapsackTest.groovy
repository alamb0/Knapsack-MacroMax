package com.knapsack.project.Knapsack

import com.knapsack.project.MealNutritionFacts
import spock.lang.Specification

class GreedyKnapsackTest extends Specification {

    GreedyKnapsack greedyKnapsack = new GreedyKnapsack()

    def "Greedy Knapsack test for maximizing protein of 400 calorie meal"() {
        given: "Three Meals in a list"
        MealNutritionFacts mealNutritionFacts1 = new MealNutritionFacts()
        mealNutritionFacts1.setCalories("300")
        mealNutritionFacts1.setProtein("20")

        MealNutritionFacts mealNutritionFacts2 = new MealNutritionFacts()
        mealNutritionFacts2.setCalories("150")
        mealNutritionFacts2.setProtein("19")

        MealNutritionFacts mealNutritionFacts3 = new MealNutritionFacts()
        mealNutritionFacts3.setCalories("150")
        mealNutritionFacts3.setProtein("19")

        List<MealNutritionFacts> meals = new ArrayList<>() << mealNutritionFacts1 << mealNutritionFacts2 << mealNutritionFacts3

        when: "Greedy Knapsack is run on the list of meals to find the meal that contains most protein"
        List<MealNutritionFacts> result = greedyKnapsack.knapsack(meals, 400, "Protein")

        then: "Non optimal solution achieved of only the meal with the most protein"
        assert result.get(0) == mealNutritionFacts1
        assert result.size() == 1
    }

}
