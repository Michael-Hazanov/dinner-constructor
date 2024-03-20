package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dishesByCategory;
    ArrayList<String> dishesToCategory;
    Random random = new Random();

    DinnerConstructor() {
        dishesByCategory = new HashMap<>();
    }

    void saveDishByCategory(String dishType, String dishName) {
        if (dishesByCategory.containsKey(dishType)) {
            ArrayList<String> dishByCategory;
            dishByCategory = dishesByCategory.get(dishType);
            dishByCategory.add(dishName);
        } else {
            ArrayList<String> dishNames = new ArrayList<>();
            dishNames.add(dishName);
            dishesByCategory.put(dishType, dishNames);
        }
        System.out.println(dishesByCategory);
    }

    void makeComboDinner(int numberOfCombos, ArrayList<String> typeOfDishes) {
        String nameOfTheDish;
        ArrayList<String> comboLunch;

        for (int i = 0; i < numberOfCombos; i++) {
            comboLunch = new ArrayList<>();
            System.out.println("Комбо " + (i + 1));
            for (String dishType : typeOfDishes) {
                dishesToCategory = dishesByCategory.get(dishType);
                nameOfTheDish = dishesToCategory.get(random.nextInt(dishesToCategory.size()));
                comboLunch.add(nameOfTheDish);
            }
            System.out.println(comboLunch);
        }
    }

    boolean checkType(String typeOfDish) {
        return dishesByCategory.containsKey(typeOfDish);
    }
}