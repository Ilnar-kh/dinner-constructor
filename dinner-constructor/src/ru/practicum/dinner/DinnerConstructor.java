package ru.practicum.dinner;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

public class DinnerConstructor {
    // Ключ – тип блюда, элементы – список блюд этого типа
    HashMap<String, ArrayList<String>> dishTypesAndNames = new HashMap<>();
    // Список типов блюд, выбранных для генерации комбинаций
    ArrayList<String> typeList = new ArrayList<>();

    Random random = new Random();

    // Добавление типа и названия блюда
    public void saveDish(String dishType, String dishName) {
        if (!dishTypesAndNames.containsKey(dishType)) {
            dishTypesAndNames.putIfAbsent(dishType, new ArrayList<>());
        }
        dishTypesAndNames.get(dishType).add(dishName);
    }

    // Ввод и проверка наличия типа блюда.
    // Если тип существует, добавляем его в список выбранных типов для генерации комбинаций.
    public void inputTypes(String nextItem) {
        if (dishTypesAndNames.containsKey(nextItem)) {
            typeList.add(nextItem);
        } else {
            System.out.println("Такой тип блюда отсутствует");
        }
    }

    // Для каждого выбранного типа рандомно выбирается блюдо.

    public void generateDishCombo(int numberOfCombos, ArrayList<String> typeList, HashMap<String, ArrayList<String>>
            dishTypesAndNames) {
        if (typeList.isEmpty()) {
            System.out.println("Не выбрано ни одного типа блюда!");
            return;
        }

        for (int comboIndex = 0; comboIndex < numberOfCombos; comboIndex++) {
            System.out.print("\nКомбо " + (comboIndex + 1) + "\n[ ");

            ArrayList<String> selectedDishes = new ArrayList<>();

            for (String type : typeList) {

                ArrayList<String> dishes = dishTypesAndNames.get(type);

                if (dishes != null && !dishes.isEmpty()) {
                    String dish = dishes.get(random.nextInt(dishes.size()));
                    selectedDishes.add(dish);
                } else {
                    selectedDishes.add("Нет блюд для \"" + type + "\"");
                }
            }

            // Для вывода списка блюд через запятую
            System.out.print(String.join(", ", selectedDishes));
            System.out.println(" ]");
        }
    }

    public void clearTypeList() {
        typeList.clear();
    }

}
