package com.knapsack.project.CSVLoader;

import com.knapsack.project.MealNutritionFacts;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads CSV File using Apache Commons CSV Library
 *
 */
@Data
@EqualsAndHashCode
@NoArgsConstructor
public class CSVLoader {

    /**
     *
     * Uses Apache Commons CSV Library to load a CSV into a List of Meals Objects
     * http://commons.apache.org/proper/commons-csv/
     *
     * @param csvFilePath The absolute path to the CSV File. Supplied by CSVLoaderService
     * @return List of the Nutrition Facts for all meals loaded from the CSV File
     * @throws FileNotFoundException if csv file does not exist
     * @throws IOException if csv file can not be parsed
     * @throws NullPointerException if records are null when trying to set meals
     */
    public List<MealNutritionFacts> load(String csvFilePath){

        Iterable<CSVRecord> records = null;
        try {
            Reader reader = new FileReader(csvFilePath);
            records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MealNutritionFacts> usdaMeals = new ArrayList<>();
        setMeals(records, usdaMeals);

        return usdaMeals;
    }

    /**
     *
     * Add all records from CSV File into a list of Meal Objects
     *
     * @param records all records from CSV File
     * @param usdaMeals empty List of meals that are set from the records in CSV
     */
    private void setMeals(Iterable<CSVRecord> records, List<MealNutritionFacts> usdaMeals) {
        for (CSVRecord record : records) {
            MealNutritionFacts meal = new MealNutritionFacts();
            meal.setBrand(record.get("brand_name"));
            meal.setMealName(record.get("item_name"));
            meal.setCalories(record.get("nf_calories"));
            meal.setCaloriesFromFat(record.get("nf_calories_from_fat"));
            meal.setTotalFat(record.get("nf_total_fat"));
            meal.setSaturatedFat(record.get("nf_saturated_fat"));
            meal.setTransFat(record.get("nf_trans_fatty_acid"));
            meal.setPolyunsaturatedFat(record.get("nf_polyunsaturated_fat"));
            meal.setMonounsaturatedFat(record.get("nf_monounsaturated_fat"));
            meal.setCholesterol(record.get("nf_cholesterol"));
            meal.setSodium(record.get("nf_sodium"));
            meal.setTotalCarbohydrate(record.get("nf_total_carbohydrate"));
            meal.setDietaryFiber(record.get("nf_dietary_fiber"));
            meal.setTotalSugars(record.get("nf_sugars"));
            meal.setProtein(record.get("nf_protein"));
            meal.setServingSize(record.get("nf_serving_size_qty"));
            meal.setServingSizeUnit(record.get("nf_serving_size_unit"));

            usdaMeals.add(meal);
        }
    }
}
