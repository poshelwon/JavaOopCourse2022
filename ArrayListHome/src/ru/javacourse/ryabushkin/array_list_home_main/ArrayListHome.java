package ru.javacourse.ryabushkin.array_list_home_main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ArrayListHome {
    public static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (toInt(list.get(i)) % 2 == 0) {
                list.remove(i);
                i--;
            }
        }

        return list;
    }

    public static ArrayList<Integer> getUniqueValuesList(ArrayList<Integer> list) {
        int length = list.size();
        ArrayList<Integer> resultList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            boolean unique = true;

            for (int item : list) {
                if (list.get(i).equals(list.get(item)) && unique) {
                    unique = false;
                    resultList.add(i);
                }
            }
        }

        return resultList;
    }

    public static ArrayList<Integer> readFileNumbers(String path) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        String string;

        while ((string = reader.readLine()) != null) {
            list.add(toInt(string));
        }

        return list;
    }

    public static int toInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }

    public static void main(String[] args) {
        String filePath = "C:\\Users\\poshelwon\\IdeaProjects\\JavaOopCourse2022\\ArrayListHome\\numbers";
        ArrayList<Integer> fileStringsList;

        try {
            fileStringsList = readFileNumbers(filePath);

            System.out.println("Исходный список: " + fileStringsList);
            System.out.println("После удаления четных чисел: " + removeEvenNumbers(fileStringsList));
        } catch (IOException e) {
            System.out.println("Не удалось прочитать файл " + filePath);
        }

        ArrayList<Integer> numbersList = new ArrayList<>() {{
            add(2);
            add(2);
            add(3);
            add(4);
            add(5);
            add(4);
        }};

        System.out.println("Назначенный список: " + numbersList);

        System.out.println("Копия назначенного списка без дубликатов: " + getUniqueValuesList(numbersList));
    }
}