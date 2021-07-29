package com.ellen.datastruct.Stack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackArrayList {
    private ArrayList<Integer> stack;

    StackArrayList(){
        stack = new ArrayList<>();
    }

    public int pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return stack.remove(stack.size()-1);
    }

    public void push(int value) {
        stack.add(value);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int  peek() {
        if(isEmpty()){
            throw  new EmptyStackException();
        }
        return stack.remove(stack.size()-1);
    }


    public int length() {
        return stack.size();
    }

}
