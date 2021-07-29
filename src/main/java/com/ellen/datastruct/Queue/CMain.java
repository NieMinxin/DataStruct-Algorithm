package com.ellen.datastruct.Queue;

public class CMain {

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);
        queue.enqueue(90);//只能存9个
        queue.enqueue(100);
        queue.enqueue(110);

        System.out.println(queue.toString());

        queue.dequeue();

        System.out.println(queue.toString());

        queue.enqueue(100);
        System.out.println(queue.toString());


    }
}
