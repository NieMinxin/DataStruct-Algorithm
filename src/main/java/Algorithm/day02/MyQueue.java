package Algorithm.day02;

import java.util.Deque;
import java.util.LinkedList;

public class MyQueue {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    public MyQueue(){
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    public void push(int x) {
        inStack.push(x);
    }
    public int pop() {
        if(outStack.isEmpty()){
            inToOut();
        }
        int x = outStack.pop();
        return x;
    }

    /** Get the front element. */
    public int peek() {
        if(outStack.isEmpty()){
            inToOut();
        }
        return outStack.peek();

    }

    private  void inToOut(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

}

