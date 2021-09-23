package Algorithm.day01;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Demo01 {
    public int firstUniqChar(String s) {
        Map<Character,Integer> map = new Hashtable<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if(map.get(ch)==1){
                return i;
            }
        }
        return -1;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer>  r  = new HashMap<>();
        Map<Character,Integer>  d  = new HashMap<>();


        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            r.put(ch, r.getOrDefault(ch,0)+1);
        }

        for (int i = 0; i <magazine.length(); i++) {
            char ch = magazine.charAt(i);
            d.put(ch, d.getOrDefault(ch,0)+1);
        }


        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);

            int a  = r.get(ch);
            int b = d.get(ch);

            if(a>b){
                return false;
            }

        }

        return true;

    }
    /*
    java.lang.NullPointerException
  at line 22, Solution.canConstruct
  at line 54, __DriverSolution__.__helper__
  at line 87, __Driver__.main
    * */
}
