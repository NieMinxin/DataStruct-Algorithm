package leetcode.novenber;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
       int arr[] = new int[len];
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
            queue.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
            sb.append(queue.pop());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
