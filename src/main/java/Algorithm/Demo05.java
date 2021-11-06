package Algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class Demo05 {
    public String replaceSpace(String s) {
        int len = s.length();
        char array[] = new char[len*3];
        int size = 0;
        for (int i = 0; i <len ; i++) {
            char ch = s.charAt(i);

            if(ch==' '){
                array[size++] = '%';
                array[size++] = '2';
                array[size++] ='0';
            }else {
                array[size++] = ch;
            }
        }
        String s1 = new String(array,0,size);
        return s1;
    }

    public String reverseLeftWords(String s, int n) {
        char array[] = s.toCharArray();
        int length = s.length();
        int size =0;
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i <length ; i++) {
            queue.offer(array[i]);
        }


        for (int i = 0; i <n ; i++) {
            queue.offer(queue.poll());
        }

        while(!queue.isEmpty()){
            array[size++] = queue.poll();
        }

        return new String(array);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(1,12);
        System.out.println(list);

    }

}
