package com.ellen.datastruct.String;

public class Main {
    public static void main(String[] args) {
            String s = "abcdeddadada";
            String s1 = "ddad";
            new Main().kmp(s,s1);
            System.out.println(new Main().kmp(s,s1));
    }



    public  int naive(String source,String target){
        int max = source.length()-target.length();

        for (int i = 0; i <=max ; i++) {
            int k=0;
            for (int j = i; k < target.length(); j++) {
                if(source.charAt(j)==target.charAt(k)){
                    k++;
                    continue;
                }else{
                    break;
                }

            }
            if(k==target.length()){
                return i;
            }

        }

        return -1;
    }

    public int kmp(String source, String target) {
        int n = source.length(), m = target.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
       //for 循环用来生成 前缀表
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && target.charAt(i) != target.charAt(j)) {
                j = pi[j - 1];
            }
            if (target.charAt(i) == target.charAt(j)) {
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && source.charAt(i) != target.charAt(j)) {
                j = pi[j - 1];//table 表的第一个元素为0 ，最后一个元素
            }
            if (source.charAt(i) == target.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }


    public int bm(String source,String target){
        return -1;
    }

}
