package leetcode.october;

import com.ellen.datastruct.List.Stack;

import java.util.Deque;
import java.util.LinkedList;

public class QueueWithTwoStack {
    private Deque<Integer> in;
    private Deque<Integer> out;
    QueueWithTwoStack(){
        in= new LinkedList();
        out = new LinkedList();
    }

    public  void offer(int value){
        in.push(value);
    }
    public int poll(){
        if(in.isEmpty() && out.isEmpty()){
            return -1;
        }else if(out.isEmpty()){
            while (!in.isEmpty()){
                out.push(in.pop());
            }
        }
        return out.pop();
    }

}
