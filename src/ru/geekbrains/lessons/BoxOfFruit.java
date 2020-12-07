package ru.geekbrains.lessons;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class BoxOfFruit <T extends Fruit> {

    // поле, указывающее на то, что фрукты хранятся в ArrayList
    private ArrayList<T> fruitList;

    // конструктор ArrayList для создание коробки с фруктами определённого типа
    public BoxOfFruit (T... fruitList) {
        this.fruitList = new ArrayList<T>(Arrays.asList(fruitList));
    }

    // метод добавления фруктов в коробку
    public void addFruit(T... fruitList) {
        this.fruitList.addAll(Arrays.asList(fruitList));
    }

    // медо удаления фруктов из коробки
    public void remove(T... fruits){
        for (T fruit : fruits) {
            this.fruitList.remove(fruit);
        }
    }

    // метод для очистки коробки
    public void clear() {
        fruitList.clear();
    }

    // геттер на проверку пустоты коробки
    public float getWeight() {
        if (fruitList.isEmpty()){
            return 0;
        } else {
        return fruitList.size() * fruitList.get(0).getWeight();
        }
    }

    // метод для "пересыпания" фруктов в другой ящик
    public void transfer(BoxOfFruit<? super T> box) {
        box.fruitList.addAll(this.fruitList);
        clear();
    }

    // сравнение веса коробок
    boolean compare(BoxOfFruit<? extends Fruit> box) {
        return this.getWeight() == box.getWeight();
    }
}
