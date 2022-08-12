package ru.javacourse.ryabushkin.vector;

import java.util.Arrays;

public class Vector {
    private final double[] vector;

    public Vector(int dimension) {
        if (dimension <= 0) {
            throw new IllegalArgumentException("Dimension must >= 0. dimension = " + dimension);
        }

        vector = new double[dimension];
    }

    public Vector(Vector vector) {
        this.vector = new double[vector.vector.length];

        for (int i = 0, j = 0; i < vector.vector.length; i++, j++) {
            this.vector[i] = vector.vector[i];
        }
    }

    public Vector(double[] vector) {
        this.vector = new double[vector.length];

        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    public Vector(int dimension, double[] vector) {
        int length = (Math.max(dimension, vector.length));
        this.vector = new double[length];

        for (int i = 0, j = 0; i < Math.min(dimension, vector.length); i++, j++) {
            this.vector[i] = vector[i];
        }
    }

    public double[] getVector() {
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
        return vector;
    }

    public void setVector(double[] vector) {
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    public static Vector getVectorsSum(Vector vector1, Vector vector2) {
        int vectorMaxLength = Math.max(vector1.getSize(), vector2.getSize());

        Vector resultVector = new Vector(vectorMaxLength);

        for (int i = 0; i < vectorMaxLength; i++) {
            resultVector.vector[i] = ((i < vector1.getSize()) ? vector1.vector[i] : 0)
                    + ((i < vector2.getSize()) ? vector2.vector[i] : 0);
        }

        return resultVector;
    }

    public static Vector getVectorsDifference(Vector vector1, Vector vector2) {
        int maxLength = Math.max(vector1.getSize(), vector2.getSize());

        Vector resultVector = new Vector(maxLength);

        for (int i = 0; i < maxLength; i++) {
            resultVector.vector[i] = ((i < vector1.getSize()) ? vector1.vector[i] : 0)
                    - ((i < vector2.getSize()) ? vector2.vector[i] : 0);
        }

        return resultVector;
    }

    public static void scalarVector(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.getSize(), vector2.getSize());

        for (int i = 0; i < minLength; i++) {
            vector1.vector[i] *= vector2.vector[i];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(("{"));

        for (double i : vector) {
            stringBuilder.append(i).append(", ");
        }

        stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 2));
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Vector vector = (Vector) obj;
        return Arrays.equals(this.vector, vector.vector);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(vector);
    }

    public int getSize() {
        return vector.length;
    }

    public void addVector(Vector vector) {
        int minLength = Math.min(this.vector.length, vector.vector.length);

        for (int i = 0; i < minLength; i++) {
            this.vector[i] += vector.vector[i];
        }
    }

    public void differenceVector(Vector vector) {
        int minLength = Math.min(this.vector.length, vector.vector.length);

        for (int i = 0; i < minLength; i++) {
            this.vector[i] -= vector.vector[i];
        }
    }

    public Vector getVectorMultiplicationScalar(int scalar) {
        Vector resultVector = new Vector(vector);

        for (int i = 0; i < resultVector.getSize(); i++) {
            resultVector.vector[i] = resultVector.vector[i] * scalar;
        }

        return resultVector;
    }

    public Vector getVectorReversal() {
        Vector resultVector = new Vector(vector);

        for (int i = 0; i < resultVector.getSize(); i++) {
            resultVector.vector[i] = resultVector.vector[i] * -1;
        }

        return resultVector;
    }

    public double getVectorLength() {
        double vectorLength = 0;

        for (double i : vector) {
            vectorLength += Math.sqrt(i * i);
        }

        return Math.abs(vectorLength);
    }

    public void setComponent(int index, double number) {
        vector[index] = number;
    }

    public double getComponent(int index) {
        return vector[index];
    }
}