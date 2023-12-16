package com.ambition.DesignPatterns.SevenPrinciples.SingleResponsibility;

/**
 * @author Ambition
 * @date 2023/10/20 22:05
 * 单一职责原则
 */
public class SingleResponsibility01 {
    public static void main(String[] args) {
        Vehicle loadVehicle = new Vehicle();
        loadVehicle.run("摩托车");
        Vehicle waterVehicle = new Vehicle();
        waterVehicle.run("轮船");

    }
}


class Vehicle {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }
}

