package ru.javacourse.ryabushkin.matrix_main;

import ru.javacourse.ryabushkin.matrix.Matrix;
import ru.javacourse.ryabushkin.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 4);

        System.out.println(matrix1);

        Matrix matrix2 = new Matrix(matrix1);

        System.out.println(matrix2);

        double[][] matrix3Array = {
                {0, 9, 8},
                {7},
                {6, 5},
                {4, 3, 2, 1}
        };

        Matrix matrix3 = new Matrix(matrix3Array);

        System.out.println(matrix3);

        Vector[] matrix4Array = {
                new Vector(new double[]{1, 2, 3}),
                new Vector(new double[]{4, 5, 6, 7}),
                new Vector(new double[]{8, 9})
        };

        Matrix matrix4 = new Matrix(matrix4Array);

        System.out.println(matrix4);
    }
}