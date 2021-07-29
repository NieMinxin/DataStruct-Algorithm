package com.ellen.datastruct.Queue;

public class CircularQueue {

    private int maxsize;
    private int rear;
    private int front;
    private  int array[];//数组
    private int items;


    //(rear + 1 ) %maxsize == front 判断是否队列满了, 队列虽然为10 个元素，但是只能存9个
    //rear ==front 为空队列
    //rear - front + maxSize) % maxSize
    CircularQueue(){
        maxsize=10;
        array = new int[10];//默认十个元素
        rear=0;
        front = 0;
        items=0;
    }

    //获取队列的元素个数
    public int getItems() {
        return items;
    }

    public boolean isEmpty() {
        return rear==front;
    }

    public boolean isFull() {
        return (rear+1)%10 ==front;
    }

    public void clear() {
        rear=front;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }else
            return array[front];
    }


    public void enqueue(int value) {
        if(isFull()){
            return;
        }else {
            array[rear]=value;
            rear = (rear+1) %maxsize;
        }
        items++;
    }

    public int dequeue(){
        if(isEmpty()){
            return -1;
        }else {

            int tmp =array[front];
            array[front] = 0;//0为清空
            front = (front+1)%maxsize;
            items--;
            return tmp;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <maxsize; i++) {
            sb.append(array[i]);
            sb.append("->");
        }
        return sb.toString();
    }
}
