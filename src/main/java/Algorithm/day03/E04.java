package Algorithm.day03;

import java.util.LinkedList;
import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len;
        LinkedList<Integer> list = new LinkedList();
        len = scanner.nextInt();
        for (int i = 0; i < len; i++) {
            list.add(scanner.nextInt());
        }

        int node = list.remove(0);

        for (int i = 0; i <list.size(); i++) {
            if (node<=list.get(i)){
                list.add(i,node);
                break;
            }
            if(i==list.size()-1){
                list.add(node);
                break;
            }
            //插入到最后
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(" ");
        }
        System.out.println(sb.toString());


    }
}
