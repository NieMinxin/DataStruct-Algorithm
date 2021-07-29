package com.ellen.datastruct.Stack;

public class StackArray {
    private   static  final  int  DEFAULT = 10;
    private int top;
    private int array[];
    private  int maxsize;
    private int len;

    StackArray(int capacity){
        capacity = DEFAULT;
        array = new int[DEFAULT];
        maxsize=DEFAULT;

        top=-1;//栈为空
    }

    public int length() {
        return top+1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
    //扩容,复制数组
    private void resize(int size){
        int newArray[] = new int[size];
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        array = newArray;//改变指向
        maxsize = size;
    }

    public boolean isFull() {
        return top+1==maxsize;
    }

    public void empty() {
        top =-1;
    }

    public int pop() {
        if (isEmpty()){
            return -1;
        }
        return array[top--];
    }

    public void  push(int value){
        if(isFull()){
            resize(maxsize*2);
            push(value);
        }else {
            top++;
            array[top] = value;
        }

    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int i = top; i>=0; i--) {
            sb.append(array[i]);
            sb.append("->");
        }
        System.out.println(sb.toString());
    }
}
