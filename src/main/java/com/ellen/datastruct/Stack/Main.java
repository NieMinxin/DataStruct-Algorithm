package com.ellen.datastruct.Stack;

public class Main {
    public static void main(String[] args) {
        StackArray stack = new StackArray(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();

        System.out.println(stack.length());
        System.out.println(stack.pop());
        stack.print();
    }
}
