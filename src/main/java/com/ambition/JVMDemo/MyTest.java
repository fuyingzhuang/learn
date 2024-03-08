package com.ambition.JVMDemo;

/**
 * @author Ambition
 * @date 2024/3/8 08:48
 */
public class MyTest {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();
        // 将maxMemory转换为GB
        System.out.println("MAX_MEMORY = " + maxMemory + " (字节)、" + (maxMemory / (double)1024 / 1024 / 1024) + "GB");
        long totalMemory = Runtime.getRuntime().totalMemory();
        // 将totalMemory转换为GB
        System.out.println("TOTAL_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024 / 1024) + "GB");
        // 获取电脑的CPU核数和内存大小和线程数和操作系统
        System.out.println("CPU核数：" + Runtime.getRuntime().availableProcessors());
        System.out.println("操作系统：" + System.getProperty("os.name"));
        System.out.println("线程数：" + Thread.activeCount());
        System.out.println("内存："+(Runtime.getRuntime().maxMemory() / (double)1024 / 1024 / 1024) + "GB");

    }
}
