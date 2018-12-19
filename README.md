# Macronutrient Knapsack Problem

## Environment and Dependencies from Vendor
[IDE - IntelliJ IDEA](https://www.jetbrains.com/idea/)   
[Java 8](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)   
[Spring Boot](http://spring.io/projects/spring-boot)   
[Thymeleaf](https://www.thymeleaf.org/)    
[Lombok](https://projectlombok.org/)  
[Spock](http://spockframework.org/)  
[Apache Commons CSV](http://commons.apache.org/proper/commons-csv/)  
[Bootstrap CSS](https://getbootstrap.com/)      
[Gradle](https://gradle.org/)  
[Nutrionix API and CSV File](https://www.nutritionix.com/)


Set the absolute path to sample csv file in the 
`application.properties` file. 

Add API and CSV from Nutritionix  
[Powered by Nutritionix](https://www.nutritionix.com/database)

Add `application.properties` to `src/main/resources`
with the following properties 

| csv.absolute.path | nutritionix.application.id | nutritionix.application.key |
| ------- | -------- | --------- |
| absolute path to csv file with nutrition facts | Nutritionix API ID | Nutritionix API KEY |
