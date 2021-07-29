package com.ellen.datastruct.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Queues {
    /** Default initial capacity. */
    private static final int DEFAULT_CAPACITY = 10;

    /** Max size of the queue */
    private int maxSize;
    /** The array representing the queue */
    private int[] queueArray;
    /** Front of the queue */
    private int front;
    /** Rear of the queue */
    private int rear;
    /** How many items are in the queue */
    private int nItems;

    Queues(){
        queueArray = new int[DEFAULT_CAPACITY];
        maxSize = DEFAULT_CAPACITY;
        front=-1;
        rear=-1;
        nItems=0;
    }

    public int getnItems() {
        return nItems;
    }

    public boolean isEmpty() {
        return  nItems==0;
    }

    public boolean isFull(){
        return nItems==maxSize;
    }


    public int peekRear(){
       return queueArray[rear];
    }

    public int peekFront() {
        return queueArray[front];
    }

    public int  remove() {
        if(isEmpty()){
            return -1;
        }else {
            nItems--;
            return queueArray[++front];
        }
    }


    public void add(int value) {
        if(isFull()){
            return;
        }
        else {
            nItems++;
            queueArray[++rear] = value;
        }
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = front+1; i < rear+1; i++) {
            sb.append(queueArray[i]);
            sb.append("->");
        }
        System.out.println(sb.toString());
    }
}
