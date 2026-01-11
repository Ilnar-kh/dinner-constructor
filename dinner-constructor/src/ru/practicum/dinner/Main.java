package ru.practicum.dinner;

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
                    System.out.println("Программа завершилась. Хорошего настроения!");
                    return;
                default:
                    System.out.println("Неверная команда! Попробуйте снова.");
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
        dc.saveDish(dishType, dishName);
        // добавьте новое блюдо
    }

    private static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        // Проверка на наличие загруженных типов и названий блюд
        if (dc.dishTypesAndNames.isEmpty()) {
            System.out.println("Не загружены типы и наименования блюд! Введите их и попробуйте снова. ");
            return;
        }
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");
        int numberOfCombos = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");
        String nextItem = scanner.nextLine();

        //реализуйте ввод типов блюд
        while (!nextItem.isEmpty()) {
            dc.inputTypes(nextItem);
            nextItem = scanner.nextLine();
        }
        // сгенерируйте комбинации блюд и выведите на экран
        dc.generateDishCombo(numberOfCombos, dc.typeList, dc.dishTypesAndNames);
        // очистка списка типов
        dc.clearTypeList();

    }
}
