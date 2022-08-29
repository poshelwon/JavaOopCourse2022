package ru.javacourse.ryabushkin.array_list_home;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHome {
    private Object[] items = new Object[6];
    private int length;

    public int size() {
        return length;
    }

    public Object get(int index) {
        if (index >= length) {
            throw new IllegalArgumentException("Index must be < length. Length = " + length + ", index = " + index);
        }

        return items[index];
    }

    public void add(Object obj) {
        if (length >= items.length) {
            increaseCapacity();
        }

        items[length] = obj;
        length++;
    }

    public void increaseCapacity() {
        items = Arrays.copyOf(items, items.length * 2);
        length = length * 2;
    }

    public void remove(int index) {
        if (index > length) {
            throw new IllegalArgumentException("Index must be < length. Length = " + length + ", index = " + index);
        }

        System.arraycopy(items, index + 1, items, index, length - index - 1);

        items[length - 1] = null;
        length--;
    }

    public int toInt(Object obj) {
        return Integer.parseInt(obj.toString());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < length; i++) {
            result.append(items[i].toString()).append(" ");
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ArrayListHome list = (ArrayListHome) obj;
        return Arrays.equals(list.items, items);
    }

    public static ArrayListHome scanFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\poshelwon\\IdeaProjects\\JavaOopCourse2022\\ArrayListHome\\numbers"));

        ArrayListHome list = new ArrayListHome();

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }

        scanner.close();

        return list;
    }

    public static ArrayListHome removeRepeats(ArrayListHome list) {
        ArrayListHome newList = new ArrayListHome();

        for (int i = 0; i < list.size(); i++) {
            newList.add(list.get(i));

            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }

        return newList;
    }
}