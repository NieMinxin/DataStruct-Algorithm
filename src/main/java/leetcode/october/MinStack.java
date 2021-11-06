package leetcode.october;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack{

    private Deque<Integer> data;
    private Deque<Integer>  min;
    public MinStack(){
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public int getMin(){

        if(!min.isEmpty()){
            return min.peek();
        }
        return  -1;
    }

    public void push(int value){
        data.push(value);
        if(min.isEmpty()){
            min.push(value);
        }else if(value<this.getMin()){
            min.push(value);
        }else {
            min.push(min.peek());
        }

    }


    public  int pop(){
        if(data.isEmpty()){
            return -1;
        }
        min.pop();
        return data.pop();
    }

}
