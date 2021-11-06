package Algorithm.day03;

import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int stride = scanner.nextInt();
        int len = scanner.nextInt();
        int array[] = new int[len];
        int array_c[] = new int[len];
        stride = stride % len;
        for (int i = 0; i <len ; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = len-1; i >=0 ; i--) {
            int index = i-stride;
            if(index<0){
                index = index + len;
            }
            array_c[index] = array[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <array_c.length; i++) {
            sb.append(array_c[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
