package Algorithm.day03;

import java.util.LinkedList;

import java.util.Scanner;


public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String arr[] = scanner.nextLine().split(",");
        int array[] = new int[arr.length];

        for (int i = 0; i < arr.length ; i++) {
            array[i] = Integer.parseInt(arr[i]);
        }

        LinkedList<Integer> oddList = new LinkedList<>();
        LinkedList<Integer> evenList = new LinkedList<>();

        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0){
                evenList.add(array[i]);
            }else {
                oddList.add(array[i]);
            }
        }

        for (int i = 0; i <evenList.size() ; i++) {
            oddList.add(evenList.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <oddList.size() ; i++) {
            sb.append(oddList.get(i));
            sb.append(",");
        }
        System.out.println(sb.deleteCharAt(sb.length()-1).toString());


    }

}
