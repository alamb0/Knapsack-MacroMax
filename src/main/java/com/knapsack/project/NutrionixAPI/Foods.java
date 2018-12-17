package com.knapsack.project.NutrionixAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Foods {
    String food_name;
    String brand_name;
    String serving_qty;
    String serving_unit;
    String serving_weight_grams;
    String nf_calories;
    String nf_total_fat;
    String nf_saturated_fat;
    String nf_cholesterol;
    String nf_sodium;
    String nf_total_carbohydrate;
    String nf_dietary_fiber;
    String nf_sugars;
    String nf_protein;
    String nf_potassium;
    String nf_p;
}
