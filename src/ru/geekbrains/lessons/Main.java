package ru.geekbrains.lessons;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static final int ARRAY_SIZE = 8;
    public static final int index1 = 3;
    public static final int index2 = 6;

    public static void main(String[] args) {

        //1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
        String[] array = arrayInitialization();
        System.out.println("Task 1\n" + "Массив до смены элементов\n" + Arrays.toString(array));

        swapElements(array, index1, index2);
        System.out.println("Массив после замены элементов местами\n" + Arrays.toString(array) + "\n");

        //2. Написать метод, который преобразует массив в ArrayList
        List<String> list = convertToList(array);
        System.out.println("Task 2\n" + list.getClass() + " : " + list + "\n");


        System.out.println("Task 3");

        Apple firstApple = new Apple();
        Apple secondApple = new Apple();
        Apple thirdApple = new Apple();
        Apple fourthApple = new Apple();

        Orange firstOrange = new Orange();
        Orange secondOrange = new Orange();

        BoxOfFruit<Apple> appleBoxOne = new BoxOfFruit();
        appleBoxOne.addFruit(firstApple,secondApple,thirdApple, fourthApple);

        BoxOfFruit<Apple> aplleBoxTwo = new BoxOfFruit();
        aplleBoxTwo.addFruit(firstApple, thirdApple);

        BoxOfFruit<Orange> orangeBox = new BoxOfFruit();
        orangeBox.addFruit(firstOrange, secondOrange, new Orange());

        Float appleBoxOneWeight = appleBoxOne.getWeight();
        Float appleBoxTwoWeight = aplleBoxTwo.getWeight();
        Float orangeBoxWeight = orangeBox.getWeight();

        System.out.println("Вес коробки с яблоками: " + appleBoxOneWeight);
        System.out.println("Вес коробки с яблоками: " + appleBoxTwoWeight);
        System.out.println("Вес коробки с апельсинами: " + orangeBoxWeight);

        aplleBoxTwo.transfer(appleBoxOne);

        Float appleBoxWeightAfterTransfer = appleBoxOne.getWeight();
        System.out.println("Вес коробки с яблоками после пересыпки: " + appleBoxWeightAfterTransfer);

        System.out.println (aplleBoxTwo.compare(orangeBox));

    }

       private static String[] arrayInitialization() {
        String [] array = new String [ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = "word" + (i+1);
        }
        return array;
    }

    private static <T> void swapElements(T[] array, int index1, int index2) {
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static <E> List<E> convertToList(E[] array) {
        return Arrays.asList(array);
    }
}
