package com.ambition.DesignPatterns.SevenPrinciples.Segregation;

/**
 * @author Ambition
 * @date 2023/10/21 14:34
 * 接口隔离原则 一个类对另一个类的依赖应该建立在最小的接口上
 */
public class Segregation {
    public static void main(String[] args) {

        new A().operation1();
        new A().operation2();
        new A().operation3();
        new A().operation4();
        new A().operation5();
    }

}

interface InterfaceOne {
    void operation1();

    void operation2();

    void operation3();

    void operation4();

    void operation5();
}

class A implements InterfaceOne {

    @Override
    public void operation1() {
        System.out.println("A 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("A 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("A 实现了 operation3");
    }

    @Override
    public void operation4() {
        System.out.println("A 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("A 实现了 operation5");
    }
}
