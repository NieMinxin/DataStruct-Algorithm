package Algorithm.day03;

import java.util.Scanner;
import java.util.Stack;

public class E01 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack();
        int length = sc.nextInt();
        int array[] = new int[length];
        for (int i = 0; i <length ; i++) {
            array[i] = sc.nextInt();
            stack.push(array[i]);
        }
        int i=0,j =length-1;
        for (int k = 0; k <length ; k++) {
            int tmp;
            if ((tmp = stack.pop())==0){
                array[i] =tmp;
                i++;
            }else {
                array[j] = tmp;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k <length ; k++) {
            sb.append(array[k]);
            sb.append(" ");
        }
        System.out.println(sb.toString());



    }


}
