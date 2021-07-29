package com.ellen.datastruct.List;

public class Main1 {
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();

        System.out.println(list.len());

        list.insertHead(10);
        list.display();
        list.insertHead(12);
        list.display();
        list.insertEleByIndex(1,11);
        list.display();

        list.peek();
        list.display();

        list.remove(10);
        list.display();

    }
}
