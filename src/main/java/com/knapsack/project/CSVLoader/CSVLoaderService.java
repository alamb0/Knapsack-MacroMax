package com.knapsack.project.CSVLoader;

import com.knapsack.project.MealNutritionFacts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CSVLoaderService {

    @Value("${csv.absolute.path}")
    String csvFilePath;

    CSVLoader csvLoader = new CSVLoader();

    List<MealNutritionFacts> meals = new ArrayList<>();

    /**
     *
     * Return Meals from CSV File
     *
     * @return A List of Meal Objects with Nutrition Facts
     */
    public List<MealNutritionFacts> loadAndStoreMealsFromCSV(){
        return meals = csvLoader.load(csvFilePath);
    }

}
