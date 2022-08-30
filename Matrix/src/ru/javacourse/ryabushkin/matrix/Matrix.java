package ru.javacourse.ryabushkin.matrix;

import ru.javacourse.ryabushkin.vector.Vector;
import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {  // +
        matrix = new Vector[n];

        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Sides must be >= 0. N = " + n + ". M = " + m);
        }

        for (int i = 0; i < n; i++) {
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) { // +
        int column = matrix.matrix.length;
        int row = matrix.matrix[1].getSize();

        for (int i = 0; i < row; i++) {
            this.matrix = Arrays.copyOf(matrix.matrix, column);
        }
    }

    public Matrix(double[][] matrix) { // +
        int columns = matrix.length;

        if (columns < 1) {
            throw new IllegalArgumentException("Columns matrix must be > 0. Columns = " + columns);
        }

        this.matrix = new Vector[columns];

        for (int i = 0; i < columns; i++) {
            int rows = matrix[i].length;

            if (rows < 1) {
                throw new IllegalArgumentException("Rows matrix must be > 0. Rows = " + rows);
            }

            this.matrix[i] = new Vector(rows);

            for (int j = 0; j < rows; j++) {
                this.matrix[i].setComponent(j, matrix[i][j]);
            }
        }
    }

    public Matrix(Vector[] vector) { // +
        this.matrix = Arrays.copyOf(vector, vector.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(("{"));

        for (Vector vector : matrix) {
            stringBuilder.append("{");

            for (int j = 0; j < vector.getSize(); j++) {
                stringBuilder.append(vector.getComponent(j)).append(", ");
            }

            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("},");
        }

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}