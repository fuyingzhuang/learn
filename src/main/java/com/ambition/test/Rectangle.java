package com.ambition.test;

/**
 * @author Ambition
 * @date 2023/10/23 22:35
 */
public class Rectangle implements IShape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getLength() {
        return 2 * (width + height);
    }
}
