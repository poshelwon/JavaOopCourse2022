package ru.javacourse.ryabushkin.vector_main;

import ru.javacourse.ryabushkin.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);

        double[] vector1Array = {1, 2, 3, 4, 5};

        vector1.setVector(vector1Array);

        Vector vector2 = new Vector(3);

        double[] vector2Array = {1, 2, 3};

        vector2.setVector(vector2Array);

        Vector vector3 = new Vector(vector2);

        int dimension = 4;

        Vector vector4 = new Vector(dimension, vector3.getVector());

        //Проверка методов, каждое изменение исходных векторов помечается "vector%№% ="
        System.out.println("vector1 = " + vector1);
        System.out.println("vector2 = " + vector2);
        System.out.println("vector3 = " + vector3);
        System.out.println("vector4 = " + vector4);

        System.out.println(Vector.getVectorsSum(vector1, vector2));

        System.out.println(Vector.getVectorsDifference(vector1, vector2));

        Vector.scalarVector(vector1, vector4);
        System.out.println("vector1 = " + vector1);

        System.out.println(vector3.equals(vector2));

        System.out.println(vector3.hashCode() == vector2.hashCode());

        vector4.addVector(vector1);
        System.out.println("vector4 = " + vector4);

        vector2.differenceVector(vector1);
        System.out.println("vector2 = " + vector2);

        System.out.println(vector1.getVectorMultiplicationScalar(2));

        System.out.println(vector2.getVectorReversal());

        System.out.println((vector1.getVectorLength()));

        double component = vector1.getComponent(0);

        vector1.setComponent(1, component);
        System.out.println("vector1 = " + vector1);
    }
}