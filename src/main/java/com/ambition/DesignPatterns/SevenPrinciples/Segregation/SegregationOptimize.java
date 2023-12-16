package com.ambition.DesignPatterns.SevenPrinciples.Segregation;

/**
 * @author Ambition
 * @date 2023/10/21 14:34
 * 接口隔离原则 一个类对另一个类的依赖应该建立在最小的接口上
 */
public class SegregationOptimize {
    public static void main(String[] args) {
        new B().operation1();
        new B().operation2();
        new C().operation3();
        new C().operation4();
        new D().operation5();
    }

}

interface InterfaceOptimizeOne {
    void operation1();

    void operation2();
}

interface InterfaceOptimizeTwo {
    void operation3();

    void operation4();
}

interface InterfaceOptimizeThree {
    void operation5();
}

class B implements InterfaceOptimizeOne {

    @Override
    public void operation1() {
        System.out.println("A 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("A 实现了 operation2");
    }
}

class C implements InterfaceOptimizeTwo {

    @Override
    public void operation3() {
        System.out.println("A 实现了 operation3");
    }

    @Override
    public void operation4() {
        System.out.println("A 实现了 operation4");
    }
}

class D implements InterfaceOptimizeThree {

    @Override
    public void operation5() {
        System.out.println("A 实现了 operation5");
    }
}
