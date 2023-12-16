package com.ambition.algorithm.datastructure.queue;

/**
 * @author Ambition
 * @date 2023/10/24 15:27
 */


// 使用数组去模拟队列
class ArrayQueue {
    private int maxSize;// 队列的最大容量
    private int[] arr;// 数组模拟队列
    private int front;// 队列头
    private int rear;// 队列尾

    // 构造函数
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;// 指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1;// 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    // 判断队列是否满
    public boolean isPull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int number) {
        if (isPull()) {
            System.out.println("队列已满，不能加入数据");
        } else {
            arr[++rear] = number;
        }
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        } else {
            return arr[++front];
        }
    }

    // 显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
        } else {
            for (int i = front + 1; i < arr.length; i++) {
                System.out.printf("arr[%d]=%d\n", i, arr[i]);
            }
        }
    }

    // 获取队列的头数据，不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        } else {
            return arr[front + 1];
        }
    }
}


public class ArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        // 添加数据
        arrayQueue.addQueue(1);
        arrayQueue.addQueue(2);
        arrayQueue.addQueue(3);
//        arrayQueue.addQueue(3);
        // 显示队列
        arrayQueue.showQueue();
//        // 取出数据
        System.out.println("取出的数据是：" + arrayQueue.getQueue());
        System.out.println("取出的数据是：" + arrayQueue.getQueue());
        System.out.println("arrayQueue.headQueue() = " + arrayQueue.headQueue());
        arrayQueue.showQueue();
    }
}
