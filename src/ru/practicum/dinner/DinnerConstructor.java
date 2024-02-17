package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    static HashMap<String, ArrayList<String>> menu;

    DinnerConstructor() {
        menu = new HashMap<>();

    }

    static void addNewDish(String category, String dishName) {
        if (checkType(category)) {
            menu.get(category).add(dishName);

        } else {
            menu.put(category, new ArrayList<>());
            menu.get(category).add(dishName);

        }
    }

    HashMap<Integer, ArrayList<String>> generateCombo(int numberOfCombos, ArrayList<String> categories) {
        HashMap<Integer, ArrayList<String>> comboMap = new HashMap<>();
        for (int i = 0; i < numberOfCombos; i++) {
            comboMap.put(i, new ArrayList<>());
            for (String category : categories) {
                int randomIndex = new Random().nextInt(menu.get(category).size());
                String comboItem = menu.get(category).get(randomIndex);
                comboMap.get(i).add(comboItem);
            }

        }
        return comboMap;
    }

    static boolean checkType(String type) {
        return menu.containsKey(type);
    }

}
