package com.ambition.DesignPatterns.SevenPrinciples.SingletonPattern;

/**
 * @author Ambition
 * @date 2023/10/25 14:18
 * 双重检查 Double-Check
 * 优点：
 * 线程安全；延迟加载；不会出现多次实例化问题
 */
public class SingletonPatternTest02 {
    public static void main(String[] args) {
        System.out.println("饿汉式 静态变量 加入双重检查");
        Singleton2 instance = Singleton2.getInstance();
        Singleton2 instance2 = Singleton2.getInstance();
        // instance 和 instance2 的hashcode值相同，说明是同一个对象
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton2 {
    // 懒汉式 线程安全
    private Singleton2() {

    }

    private static volatile Singleton2 instance;

    // 提供一个静态的公共方法 加入双重代码检查 解决线程安全问题 同时解决懒加载问题

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            synchronized (Singleton2.class) {
                if (instance == null) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }

}
