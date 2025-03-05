package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static DinnerConstructor dinnerConstructor;
    static Scanner scanner;

    public static void main(String[] args) {

        dinnerConstructor = new DinnerConstructor();
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
                    System.out.println("Завершение программы...");
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

        // добавьте новое блюдо
        dinnerConstructor.saveDishByCategory(dishType, dishName);
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        if (dinnerConstructor.dishesByCategory.isEmpty()) {
            System.out.println("Меню пусто, сначала добавьте блюда" + "\n");
            return;
        }

        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();
        if (numberOfCombos <= 0) {
            System.out.println("Количество наборов должно быть больше нуля. Попробуйте еще раз" + "\n");
            return;
        }

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter)." +
                " Для завершения ввода введите пустую строку");
        String typeOfDish = scanner.nextLine();
        ArrayList<String> typeOfDishes = new ArrayList<>();
        //реализуйте ввод типов блюд
        while (!typeOfDish.isEmpty()) {
            if (!dinnerConstructor.checkType(typeOfDish)) {
                System.out.println(typeOfDish + " отсутствует в меню, введите другой тип:");
            } else {
                typeOfDishes.add(typeOfDish);
            }
            typeOfDish = scanner.nextLine();
        }
        // сгенерируйте комбинации блюд и выведите на экран
        dinnerConstructor.makeComboDinner(numberOfCombos, typeOfDishes);
    }
}