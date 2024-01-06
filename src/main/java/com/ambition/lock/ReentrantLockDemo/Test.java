package com.ambition.lock.ReentrantLockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Ambition
 * @date 2024/1/2 16:34
 * 锁的底层原理 其实是将线程阻塞 使其进入等待状态
 * 加锁 lock 阻塞线程
 * wait 阻塞线程
 * sleep 阻塞线程
 * park 阻塞线程
 * while(true) 阻塞线程
 * 累 累
 */
public class Test {
    /**
     * 非公平锁 和 公平锁
     * 非公平锁：线程获取锁的顺序是随机的
     * 公平锁：线程获取锁的顺序是按照线程的启动顺序来的
     *
     */


    /**
     * park 阻塞线程 使其进入等待状态 但是不会释放锁 与wait不同 wait会释放锁
     * park释放锁需要手动调用unpark
     * @param args
     */
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
//        DiyLock reentrantLock = new DiyLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                try {
                    drawMoney();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "小明").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    reentrantLock.lock();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                try {
                    drawMoney();
                } finally {
                    reentrantLock.unlock();
                }
            }
        }, "小红").start();

    }

    private static void drawMoney() {
        System.out.println("线程" + Thread.currentThread().getName());
        System.out.println("取钱");
        sleep(3000);
        System.out.println("取钱完毕");
    }

    private static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
