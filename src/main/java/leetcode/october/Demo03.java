package leetcode.october;

import Algorithm.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("23".length());
    }


    //当题目中出现 “所有组合” 等类似字眼时，我们第一感觉就要想到用回溯。
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if(digits==null || digits.length()==0){
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuilder());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuilder combination) {
        int len = digits.length();
        if(index==len){
            combinations.add(combination.toString());
        }else {
            char ch = digits.charAt(index);
            String letters = phoneMap.get(ch);
            //进行组合
            for (int i = 0; i < letters.length(); i++) {
                combination.append(letters.charAt(i));//
                backtrack(combinations,phoneMap,digits,index+1,combination);
                combination.deleteCharAt(index);
            }
        }
    }

    //合并K个链表
    public ListNode mergeKLists(ListNode[] lists) {
        return null;
    }



}
