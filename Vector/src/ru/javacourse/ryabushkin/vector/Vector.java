package ru.javacourse.ryabushkin.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size must be > 0. Size = " + size);
        }

        components = new double[size];
    }

    public Vector(Vector vector) {
        int size = vector.components.length;

        this.components = Arrays.copyOf(vector.components, size);
    }

    public Vector(double[] components) {
        int size = components.length;

        if (size < 1) {
            throw new IllegalArgumentException("Size must be > 0. Size = " + size);
        }

        this.components = Arrays.copyOf(components, size);
    }

    public Vector(int size, double[] vectorComponents) {
        if (size < 1 || vectorComponents.length < 1) {
            throw new IllegalArgumentException("Size and array length must be > 0. "
                    + "Size = " + size + ", array length = " + vectorComponents.length);
        }

        this.components = new double[size];

        System.arraycopy(vectorComponents, 0, this.components, 0,
                vectorComponents.length > size ? size : vectorComponents.length);
    }

    public double[] getVectorComponents() {
        return components;
    }

    public void setVectorComponents(double[] vectorComponents) {
        this.components = vectorComponents;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(("{"));

        for (double component : components) {
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
        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Arrays.hashCode(components);
    }

    public int getSize() {
        return components.length;
    }

    public void add(Vector vector) {
        int maxSize = Math.max(this.components.length, vector.components.length);

        this.components = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            this.components[i] = ((i < this.components.length) ? this.components[i] : 0)
                    + ((i < vector.components.length) ? vector.components[i] : 0);
        }
    }

    public void subtract(Vector vector) {
        int maxSize = Math.max(this.components.length, vector.components.length);

        this.components = new double[maxSize];

        for (int i = 0; i < maxSize; i++) {
            this.components[i] = ((i < this.components.length) ? this.components[i] : 0)
                    - ((i < vector.components.length) ? vector.components[i] : 0);
        }
    }

    public void multiplyByScalar(double scalar) {
        int size = components.length;

        for (int i = 0; i < size; i++) {
            components[i] *= scalar;
        }
    }

    public void reverse() {
        multiplyByScalar(-1);
    }

    public double getLength() {
        double sum = 0;

        for (double component : components) {
            sum += component * component;
        }

        return Math.sqrt(sum);
    }

    public void setComponent(int index, double number) {
        components[index] = number;
    }

    public double getComponent(int index) {
        return components[index];
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
        int maxSize = Math.max(vector1.components.length, vector2.components.length);

        double product = 0;

        for (int i = 0; i < maxSize; i++) {
            product += ((i < vector1.components.length) ? vector1.components[i] : 0)
                    * ((i < vector2.components.length) ? vector2.components[i] : 0);
        }

        return product;
    }
}