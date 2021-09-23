package leetcode;

import org.junit.Test;

import java.util.*;

public class Main {

    /*
    * */
    //输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
    //双指针解法
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char s1[]  = s.toCharArray();
        char s2[]  = s.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);


        return Arrays.equals(s1,s2);
    }


    public static void main(String[] args) {
        TreeMap map  = new TreeMap(new StudentComparator());
        map.put(new Student(10),"1");
        map.put(new Student(8),"2");
        map.put(new Student(20),"3");
        System.out.println(map.comparator());
        System.out.println(map);

    }


}
