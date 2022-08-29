package ru.javacourse.ryabushkin.array_list_home_main;

import ru.javacourse.ryabushkin.array_list_home.ArrayListHome;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayListHome list1 = ArrayListHome.scanFile();

        System.out.println("Исходный список: " + list1);

        for (int i = 0; i < list1.size(); i++) {
            if (list1.toInt(list1.get(i)) % 2 == 0) {
                list1.remove(i);
                i--;
            }
        }

        System.out.println("После удаления четных чисел: " + list1);

        ArrayListHome list2 = ArrayListHome.removeRepeats(ArrayListHome.scanFile());

        System.out.println("Новый список без повторений: " + list2);
    }
}