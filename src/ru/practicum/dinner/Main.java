package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            switch (command) {
                case "1":
                    addNewDish();
                    break;
                case "2":
                    generateDishCombo();
                    break;
                case "3":
                    return;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");
        String dishType = scanner.nextLine();
        System.out.println("Введите название блюда:");
        String dishName = scanner.nextLine();
        dc.addNewDish(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> typesOfDishes = new ArrayList<>();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();
        typesOfDishes.add(nextItem);
        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            if (nextItem.isEmpty()) {
                break;
            }
            typesOfDishes.add(nextItem);
        }
        // сгенерируйте комбинации блюд и выведите на экран
        HashMap<Integer, ArrayList<String>> comboMap = dc.generateCombo(numberOfCombos, typesOfDishes);
        for (Integer comboNumber : comboMap.keySet()) {
            System.out.println("Комбо " + (comboNumber + 1));
            System.out.println(comboMap.get(comboNumber));
        }
    }
}
