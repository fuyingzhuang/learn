package com.ambition;


import java.lang.reflect.Method;

/**
 * @author Ambition
 * @date 2024/1/17 21:53
 * 注解学习
 * 注解仅仅是一个标记 后续可以通过反射获取到这个标记 从而做一些事情
 */
public class AnnotationTest {


    @InitDemo
    public void test() {
        System.out.println("test");

    }


    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.ambition.InitDemo");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method);
            // 判断方法上是否有注解
            boolean annotationPresent = method.isAnnotationPresent(InitDemo.class);
            if (annotationPresent) {
                System.out.println("method = " + method);
                method.invoke(aClass.newInstance());
            }
        }
    }
}
