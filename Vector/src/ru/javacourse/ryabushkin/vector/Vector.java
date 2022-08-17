package ru.javacourse.ryabushkin.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;

    public Vector(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be > 0. size = " + size);
        }

        vectorComponents = new double[size];
    }

    public Vector(Vector vector) {
        int size = vector.vectorComponents.length;

        this.vectorComponents = new double[size];

        System.arraycopy(vector.vectorComponents, 0, this.vectorComponents, 0, size);
    }

    public Vector(double[] vectorComponents) {
        int size = vectorComponents.length;

        if (size < 1) {
            throw new IllegalArgumentException("Size must be > 0. size = " + size);
        }

        this.vectorComponents = new double[size];

        System.arraycopy(vectorComponents, 0, this.vectorComponents, 0, size);
    }

    public Vector(int size, double[] vectorComponents) {
        if (size < 1 || vectorComponents.length < 1) {
            throw new IllegalArgumentException("Size and array length must be > 0. "
                    + "size = " + size + ", array length = " + vectorComponents.length);
        }

        this.vectorComponents = new double[size];

        System.arraycopy(vectorComponents, 0, this.vectorComponents, 0,
                vectorComponents.length > size ? size : vectorComponents.length);
    }

    public double[] getVectorComponents() {
        return vectorComponents;
    }

    public void setVectorComponents(double[] vectorComponents) {
        this.vectorComponents = vectorComponents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(("{"));

        for (double component : vectorComponents) {
            stringBuilder.append(component).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
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
        return Arrays.equals(this.vectorComponents, vector.vectorComponents);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(vectorComponents);
    }

    public int getSize() {
        return vectorComponents.length;
    }

    public void add(Vector vector) {
        int maxSize = Math.max(this.vectorComponents.length, vector.vectorComponents.length);

        this.vectorComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            this.vectorComponents[i] = ((i < this.vectorComponents.length) ? this.vectorComponents[i] : 0)
                    + ((i < vector.vectorComponents.length) ? vector.vectorComponents[i] : 0);
        }
    }

    public void subtract(Vector vector) {
        int maxSize = Math.max(this.vectorComponents.length, vector.vectorComponents.length);

        this.vectorComponents = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            this.vectorComponents[i] = ((i < this.vectorComponents.length) ? this.vectorComponents[i] : 0)
                    - ((i < vector.vectorComponents.length) ? vector.vectorComponents[i] : 0);
        }
    }

    public void multiplyOnScalar(double scalar) {
        int size = vectorComponents.length;

        for (int i = 0; i < size; i++) {
            vectorComponents[i] *= scalar;
        }
    }

    public void reverse() {
        this.multiplyOnScalar(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double component : vectorComponents) {
            sum += component * component;
        }

        return Math.abs(Math.sqrt(sum));
    }

    public void setComponent(int index, double number) {
        vectorComponents[index] = number;
    }

    public double getComponent(int index) {
        return vectorComponents[index];
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        resultVector.add(vector2);

        return resultVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultVector = new Vector(vector1);

        resultVector.subtract(vector2);

        return resultVector;
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.vectorComponents.length, vector2.vectorComponents.length);

        double product = 0;

        for (int i = 0; i < maxSize; i++) {
            product += ((i < vector1.vectorComponents.length) ? vector1.vectorComponents[i] : 0)
                    * ((i < vector2.vectorComponents.length) ? vector2.vectorComponents[i] : 0);
        }

        return product;
    }
}