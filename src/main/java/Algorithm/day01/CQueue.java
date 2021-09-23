package Algorithm.day01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class CQueue {
    private Deque<Integer> inStack;
    private Deque<Integer> outStack;
    public CQueue() {
        inStack = new LinkedList();
        outStack = new LinkedList();
    }

    public void appendTail(int value) {
        inStack.push(value);
    }

    public int deleteHead() {
        if(outStack.isEmpty()){
            inToOut();
        }

        if(outStack.isEmpty()){
            return -1;
        }else {
            return outStack.pop();
        }
    }

    private  void inToOut(){
        while (!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
    }
}
