package com.ambition.lock.ReentrantLockDemo;

/**
 * @author Ambition
 * @date 2024/1/2 16:56
 * 自定义锁 模拟锁的底层原理 lock unlock
 */
public class DiyLock {
    private boolean isLock = false;

    public synchronized void lock() throws InterruptedException {
        while (isLock) {
            wait();
        }
        isLock = true;
    }

    public synchronized void unlock() {
        isLock = false;
        notify();
    }
}
