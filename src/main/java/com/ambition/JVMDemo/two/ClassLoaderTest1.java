package com.ambition.JVMDemo.two;

import sun.misc.Launcher;
import sun.security.util.CurveDB;

import java.net.URL;

/**
 * @author Ambition
 * @date 2024/2/22 09:50
 */
public class ClassLoaderTest1 {
    public static void main(String[] args) {

        // 获取系统类加载器
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toExternalForm());
        }

    }

}
