package ru.javacourse.ryabushkin.matrix;

import ru.javacourse.ryabushkin.vector.Vector;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int n, int m) {  // +
        matrix = new Vector[n];

        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("N,m must >= 0. n = " + n + ". m = " + m);
        }

        for (int i = 0; i < n; i++){
            matrix[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        int column = matrix.matrix.length;
        int row = matrix.matrix[1].getSize();

        for (int i = 0; i < row; i++) {
            System.arraycopy(matrix.matrix, 0, this.matrix, 0, column);
        }
    }

    public Matrix(double[][] matrix) {
        int column = matrix.length;
        int row = matrix[1].length;

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                this.matrix[i].setComponent(j, matrix[i][j]);
            }
        }
    }

    public Matrix(Vector[] vector) {
        matrix = new Vector[vector.length];
        Vector[] tempVector = new Vector[vector.length];

        System.arraycopy(vector, 0, tempVector, 0, vector.length);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder(("{"));

        for (int i = 0; i < matrix.length; i++){
            stringBuilder.append("{");

            for (int j = 0; j < matrix[i].getSize(); j++){
                stringBuilder.append(matrix[i].getComponent(j) + ", ");
            }

            stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
            stringBuilder.append("},");
        }

        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}