package ru.javacourse.ryabushkin.array_list_home_main;

import ru.javacourse.ryabushkin.array_list_home.ArrayListHome;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayListHome list1 = ArrayListHome.scanFile();

        for (int i = 0; i < list1.size(); i++) {
            System.out.print(list1.get(i) + " ");
        }
        System.out.println();

        for (int i = 0; i < list1.size(); i++) {
            if (list1.toInt(list1.get(i)) % 2 == 0) {
                list1.remove(i);
                i--;
            }
        }

        System.out.println(list1);

        ArrayListHome list2 = ArrayListHome.removeRepeats(ArrayListHome.scanFile());

        for (int i = 0; i < list2.size(); i++) {
            System.out.print(list2.get(i) + " ");
        }
        System.out.println();
    }
}