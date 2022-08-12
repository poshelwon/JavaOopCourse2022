package ru.javacourse.ryabushkin.shapes;

public class Square implements Shape {
    private double sideLength;
    private static final int SIDES_COUNT = 4;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Square square = (Square) obj;
        return sideLength == square.sideLength;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;

        return prime * hash + Double.hashCode(sideLength);
    }

    @Override
    public String toString() {
        return "Shape = " + getName() + ", sideLength = " + sideLength + ", area = " + getArea()
                + ", perimeter = " + getPerimeter();
    }

    @Override
    public String getName() {
        return "square";
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return sideLength * SIDES_COUNT;
    }
}