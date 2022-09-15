package ru.javacourse.ryabushkin.array_list_home_main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class ArrayListHome<E> extends ArrayList<E> {
    public ArrayListHome<E> removeEven() {
        for (int i = 0; i < size(); i++) {
            if (toInt(get(i)) % 2 == 0) {
                remove(i);
                i--;
            }
        }

        return this;
    }

    public ArrayListHome<E> removeRepeat() {
        HashSet<E> tempSet = new HashSet<>(this);

        ArrayListHome<E> newList = new ArrayListHome<>();
        newList.addAll(tempSet);

        return newList;
    }

    public static ArrayListHome<Integer> scanFile(String path) throws FileNotFoundException {
        ArrayListHome<Integer> list = new ArrayListHome<>();
        String bufferLine;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while ((bufferLine = reader.readLine()) != null) {
                list.add(toInt(bufferLine));
            }
        } catch (IOException e) {
            throw new FileNotFoundException();
        }

        return list;
    }

    public static int toInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\poshelwon\\IdeaProjects\\JavaOopCourse2022\\ArrayListHome\\numbers";
        ArrayListHome<Integer> fileStringsList;

        try {
            fileStringsList = scanFile(filePath);

            System.out.println("Исходный список: " + fileStringsList);
            System.out.println("После удаления четных чисел: " + fileStringsList.removeEven());
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось прочитать файл " + filePath);
        }

        ArrayListHome<Integer> numbersList = new ArrayListHome<>();

        numbersList.add(2);
        numbersList.add(2);
        numbersList.add(3);
        numbersList.add(4);
        numbersList.add(5);
        numbersList.add(4);

        System.out.println("Назначенный список: " + numbersList);

        System.out.println("Копия назначенного списка без дубликатов: " + numbersList.removeRepeat());
    }
}