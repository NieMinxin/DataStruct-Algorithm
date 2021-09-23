package Algorithm.day03;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count[] = new int[10];
        try {
            int num = scanner.nextInt();
            while (num>0){
                String s = String.valueOf(num);
                for (int i = 0; i <s.length() ; i++) {
                    char c = s.charAt(i);
                    count[c-'0']++;
                }
                num = num-1;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <count.length ; i++) {
                sb.append(count[i]);
                sb.append(" ");
            }

        }catch (NoSuchElementException e){
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i <10 ; i++) {
                stringBuilder.append(0);
                stringBuilder.append(" ");
            }
            System.out.println(stringBuilder.toString());
        }finally {
            scanner.close();
        }

    }
}
