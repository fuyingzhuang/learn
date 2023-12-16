package com.ambition.algorithm.datastructure.queue;

/**
 * @author Ambition
 * @date 2023/10/25 17:50
 * 环形队列
 */
public class AnnularArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class AnnularArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    // 构造函数
    public AnnularArray(int maxSize) {
        this.maxSize = maxSize; // 因为是环形队列，所以要预留一个空间
        arr = new int[maxSize];
        front = 0; // 指向队列头部，分析出front是指向队列头的前一个位置
        rear = 0; // 指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    // 判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }


}
