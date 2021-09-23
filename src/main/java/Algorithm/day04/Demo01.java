package Algorithm.day04;

import java.util.Arrays;

public class Demo01 {

    public int[]  bubbleSort(int []array){

        for (int i = 0; i < array.length; i++) {

            for (int j = 0; j <array.length -i -1 ; j++) {
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }

        }
        return array;
    }

    // 1 代表 s1> s2,0 相等 ，-1小于
    public int cmpStr(String s1 ,String s2){
        if(s1.length()>s2.length()){
            return 1;
        }else if(s1.length()<s2.length()){
            return -1;
        }else {
            for (int i = 0; i <s1.length() ; i++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(i);
                if(c1>c2){
                    return 1;
                }else if(c1<c2){
                    return -1;
                }else {
                    continue;
                }
            }
            return 0;
        }
    }

    public float add(float a,float b){return a+b;}
    public double add(double a,double b){return a+b;}
    public int add(int a,int b){
        return a+b;
    }


    public  boolean isPerfect(int num){

            int sum=0;
            for (int j = 1; j <num ; j++) {
                if(num%j==0){
                    sum +=j;
                }
            }
            if(sum==num){
                return true;
            }else {
                return false;
            }
    }



   public   boolean isPalindrome(int num){
        String s = String.valueOf(num);
        int i =0,j=s.length()-1;

        while (i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }else {
                return false;
            }
        }
        return true;
    }

    /*public boolean isPalindrome(int n){
        int reversedInteger = 0, remainder, originalInteger;
        while( n!=0 )
        {
            remainder = n%10;
            reversedInteger = reversedInteger*10 + remainder;
            n /= 10;
        }

        return reversedInteger==n;
    }*/


    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();

        /*int array[] = new int[]{2,7,1,9,11,23,45,21,17,22};

        System.out.println(Arrays.toString(demo01.bubbleSort(array)));*/

       /* String s1 = new String("hello");
        String s2 = new String("hello");

        System.out.println(demo01.cmpStr(s1,s2));*/


        //System.out.println(demo01.add(10,20));

/*
       if(demo01.isPerfect(200)){
           System.out.println("200"+"是完数");
       }else {
           System.out.println("200"+"不是完数");
       }*/

        if(demo01.isPalindrome(223322)){
            System.out.println("223322"+"是回文数");
        }

    }













}
