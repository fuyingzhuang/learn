package com.ambition.JVMDemo.two;

/**
 * @author Ambition
 * @date 2024/2/22 11:21
 */
public class ClassLoaderTest3 {
    public static void main(String[] args) {
        // 获取类加载启的几种方式
        // 1.
        try {
            Class<?> aClass = Class.forName("java.lang.String");
            System.out.println(aClass.getClassLoader());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 2.
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);

        // 3.
        ClassLoader classLoader1 = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader1);
    }
}
