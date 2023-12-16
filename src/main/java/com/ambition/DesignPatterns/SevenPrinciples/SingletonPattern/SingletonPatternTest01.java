package com.ambition.DesignPatterns.SevenPrinciples.SingletonPattern;

/**
 * @author Ambition
 * @date 2023/10/25 14:18
 * 单例模式 饿汉式 静态变量 线程安全
 * 优点：
 * 写法简单 在类装载的时候就完成了实例化，避免了线程同步问题
 * 缺点：
 * 在类装载的时候就完成了实例化，没有达到Lazy Loading的效果，如果从始至终从未使用过这个实例，则会造成内存的浪费
 * <p>
 */
public class SingletonPatternTest01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // instance 和 instance2 的hashcode值相同，说明是同一个对象
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {
    //   构造器私有化，外部不能new 只能通过getInstance()获取实例
    //   以下是静态常量的写法
//    private Singleton() {
//
//    }
//
//
//    private final static Singleton instance = new Singleton();
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    //   以下是静态代码块的写法
    private Singleton() {

    }

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }

}
