package com.ambition.test;

/**
 * @author Ambition
 * @date 2023/10/23 22:33
 */
public class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getLength() {
        return 2 * PI * radius;
    }
}
