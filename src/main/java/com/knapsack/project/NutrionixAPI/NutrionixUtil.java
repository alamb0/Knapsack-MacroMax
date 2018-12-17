package com.knapsack.project.NutrionixAPI;

import com.knapsack.project.MealNutritionFacts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NutrionixUtil {

    private final String ENDPOINT = "https://trackapi.nutritionix.com/v2/natural/nutrients";

    @Value("${nutritionix.application.id}")
    String nutritionixAapplicationID;

    @Value("${nutritionix.application.key}")
    String nutritionixApplicationKey;

    @RequestMapping("/nutritionix")
    public List<MealNutritionFacts> postNutritionix(String customSearch){

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("x-app-id", nutritionixAapplicationID);
        headers.add("x-app-key", nutritionixApplicationKey);

        String body = "{\"query\":\""+customSearch+"\",\"timezone\":\"US\"}";

        HttpEntity<String> entity = new HttpEntity<>(body, headers);

        ResponseEntity<RequestWrapper> response = restTemplate.exchange(ENDPOINT, HttpMethod.POST, entity, new ParameterizedTypeReference<RequestWrapper>(){});

        List<MealNutritionFacts> meals = new ArrayList<>();

        //convert response to meals
        for(int i = 0; i < response.getBody().foods.size(); i++){
            MealNutritionFacts mealNutritionFacts = getMealsFromResponse(response.getBody().foods.get(i));
            meals.add(mealNutritionFacts);
        }

        return meals;
    }

    private MealNutritionFacts getMealsFromResponse(Foods foods) {

        MealNutritionFacts mealNutritionFacts = new MealNutritionFacts();
        mealNutritionFacts.setMealName(foods.getFood_name());
        mealNutritionFacts.setServingSize(foods.getServing_qty());
        mealNutritionFacts.setServingSizeUnit(foods.getServing_unit());
        mealNutritionFacts.setCalories(foods.getNf_calories());
        mealNutritionFacts.setProtein(foods.getNf_protein());
        mealNutritionFacts.setTotalFat(foods.getNf_total_fat());
        mealNutritionFacts.setTotalCarbohydrate(foods.getNf_total_carbohydrate());

        return mealNutritionFacts;
    }

}
