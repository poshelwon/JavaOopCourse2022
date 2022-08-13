package ru.javacourse.ryabushkin.shapes_main;

import ru.javacourse.ryabushkin.shapes.*;

import java.util.Arrays;

public class Main {
    private static Shape getMaxAreaShape(Shape[] shapes) {
        if (shapes.length == 0) {
            throw new IllegalArgumentException("Array length must be > 0. Length = " + shapes.length);
        }

        Arrays.sort(shapes, new AreaComparator());

        return shapes[shapes.length - 1];
    }

    private static Shape getSecondMaxPerimeterShape(Shape[] shapes) {
        if (shapes.length < 2) {
            throw new IllegalArgumentException("Array length must be > 1. Length = " + shapes.length);
        }

        Arrays.sort(shapes, new PerimeterComparator());

        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape[] shapes = {
                new Square(9),
                new Circle(1),
                new Square(1.5),
                new Triangle(-1, 1, 0, 2, 4, 1),
                new Rectangle(1.5, 2),
                new Circle(0.5),
                new Triangle(0, 0, 5, 5, -5, 5),
                new Square(2.5),
                new Rectangle(0.5, 3)
        };

        Shape maxAreaShape = getMaxAreaShape(shapes);
        System.out.println("Max area: " + maxAreaShape);

        Shape secondMaxPerimeterShape = getSecondMaxPerimeterShape(shapes);
        System.out.println("Second max perimeter: " + secondMaxPerimeterShape);
    }
}