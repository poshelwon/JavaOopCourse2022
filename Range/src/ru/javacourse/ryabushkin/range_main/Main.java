package ru.javacourse.ryabushkin.range_main;

import ru.javacourse.ryabushkin.range.Range;

public class Main {
    public static void printRanges(Range[] ranges) {
        if (ranges.length > 0) {
            System.out.print("[");

            for (Range range: ranges) {
                System.out.println(range + ", ");
            }

            System.out.println("]");
        } else {
            System.out.println("[]");
        }
       /* StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        if (ranges.length > 0) {
            for (Range range : ranges) {
                stringBuilder.append(range).append(", ");
            }

            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        }

        stringBuilder.append("]");

        System.out.print(stringBuilder); */
    }

    public static void main(String[] args) {
        double range1From = 0;
        double range1To = 7;

        Range range1 = new Range(range1From, range1To);

        range1From = range1.getFrom() - 1;
        range1To = range1.getTo() - 1;

        range1.setFrom(range1From);
        range1.setTo(range1To);

        double range2From = 4;
        double range2To = 5;

        Range range2 = new Range(range2From, range2To);

        range2From = range2.getFrom() + 1;
        range2To = range2.getTo() + 1;

        range2.setFrom(range2From);
        range2.setTo(range2To);

        double number = 5.14;

        if (range1.isInside(number) && range2.isInside(number)) {
            System.out.println("Число " + number + " принадлежит каждому интервалу.");
        } else if (range1.isInside(number)) {
            System.out.println("Число " + number + " принадлежит первому интервалу.");
        } else if (range2.isInside(number)) {
            System.out.println("Число " + number + " принадлежит второму интервалу.");
        } else {
            System.out.println("Число " + number + " не принадлежит интервалам.");
        }

        System.out.println("Длина первого интервала = " + range1.getLength());

        Range rangesIntersection = range1.getIntersection(range2);

        if (rangesIntersection == null) {
            System.out.println("Интервалы не пересекаются.");
        } else {
            System.out.println("Интервалы пересекаются в диапазоне: " + rangesIntersection);
        }

        Range[] rangesUnion = range1.getUnion(range2);

        System.out.print("Объединение двух интервалов располагается в диапазоне: ");
        printRanges(rangesUnion);
        System.out.println();

        Range[] rangesDifference = range1.getDifference(range2);

        System.out.print("Разность двух интервалов располагается в диапазоне: ");
        printRanges(rangesDifference);
        System.out.println();
    }
}