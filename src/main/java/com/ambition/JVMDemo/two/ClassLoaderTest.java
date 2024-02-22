package com.ambition.JVMDemo.two;

/**
 * @author Ambition
 * @date 2024/2/22 09:50
 */
public class ClassLoaderTest {
    /**
     * 各种类加载器的关系
     * 1. bootstrapClassLoader: 启动类加载器，这个是用C/C++实现的，是JVM自带的类加载器，负责加载Java的核心类库，如：rt.jar、resources.jar、charsets.jar等
     * 并不继承自java.lang.ClassLoader，没有父加载器
     * 加载扩展类和应用程序类加载器，并指定为他们的父类加载器
     * 出于安全考虑，BootstrapClassLoader只加载包名为java、javax、sun等开头的类
     * 2. extClassLoader: 扩展类加载器，负责加载Java的扩展类库，如：jre/lib/ext目录下的jar包或指定的java.ext.dirs目录下的jar包
     * 用java语言实现，继承自java.lang.ClassLoader，父加载器为启动类加载器
     * 3. appClassLoader: 应用程序类加载器，负责加载应用程序classpath目录下的类，是最常用的加载器
     * 用java语言实现，继承自java.lang.ClassLoader，父加载器为扩展类加载器
     * 父类加载器为扩展类加载器 负责加载环境变量classpath或者java.class.path指定的路径下的类
     * 该类加载器是程序中默认的类加载器 一般来说，Java应用的类都是由它来完成加载的
     * 通过ClassLoader.getSystemClassLoader()来获取该类加载器
     * 4. 自定义类加载器
     * 通过继承java.lang.ClassLoader类的方式实现自定义的类加载器
     * 一般情况下，自定义类加载器的父加载器为应用程序类加载器
     * 通过重写findClass()方法实现自定义的类加载器
     * 通过重写loadClass()方法实现委托机制
     * 通过重写findResource()方法实现自定义的资源加载器
     * 通过重写findLibrary()方法实现自定义的本地库加载器
     * 通过重写getResourceAsStream()方法实现自定义的资源加载器
     * 通过重写loadClass()方法实现自定义的类加载器
     * 通过重写findLibrary()方法实现自定义的本地库加载器
     * 通过重写getResourceAsStream()方法实现自定义的资源加载器
     * 通过重写findLibrary()方法实现自定义的本地库加载器
     * 通过重写getResourceAsStream()方法实现自定义的资源加载器
     * 通过重写findLibrary()方法实现自定义的本地库加载器
     * ...
     * 为什么要自定义类加载器？
     * 1. 隔离加载类
     * 2. 修改类加载的方式
     * 3. 扩展类加载的方式
     * 4. 防止源码泄露
     */
    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader); //sun.misc.Launcher$ExtClassLoader@1540e19d
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader); //null
    }


}
