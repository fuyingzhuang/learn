package com.ambition.test;

import java.text.DecimalFormat;

/**
 * @author Ambition
 * @date 2023/10/23 22:20
 */
public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(6.0);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        System.out.println("圆的半径为：" + 6.0);
        System.out.println("圆的面积为：" + decimalFormat.format(circle.getArea()));
        System.out.println("圆的周长为：" + decimalFormat.format(circle.getLength()));
        Rectangle rectangle = new Rectangle(6.7, 9.8);
        System.out.println("长方形的长为：" + 6.7);
        System.out.println("长方形的宽为：" + 9.8);
        System.out.println("长方形的面积为：" + decimalFormat.format(rectangle.getArea()));
        System.out.println("长方形的周长为：" + decimalFormat.format(rectangle.getLength()));


    }
}
