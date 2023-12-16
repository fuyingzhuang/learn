package com.ambition.DesignPatterns.SevenPrinciples.SingleResponsibility;

/**
 * @author Ambition
 * @date 2023/10/20 22:05
 * 单一职责原则 每一个类负责专门的一个功能
 */
public class SingleResponsibility02 {
    public static void main(String[] args) {
        Vehicle2 loadVehicle = new Vehicle2();
        loadVehicle.run("摩托车");
        Vehicle2 waterVehicle = new Vehicle2();
        waterVehicle.runWater("轮船");

    }
}


class Vehicle2 {
    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天空上运行");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水中运行");
    }
}

