package com.ellen.datastruct.Queue;

public class Main {
    public static void main(String[] args) {
        Queues queues = new Queues();

        queues.add(10);
        queues.add(20);
        queues.add(30);
        queues.add(40);

        queues.print();

        queues.remove();
        queues.print();
    }
}
