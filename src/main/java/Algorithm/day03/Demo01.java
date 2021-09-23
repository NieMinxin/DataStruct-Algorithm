package Algorithm.day03;

import java.util.HashMap;
import java.util.Map;

public class Demo01 {

    public int minArray(int[] numbers) {
        int low =0;
        int high = numbers.length-1;

        while (low<high){
            int middle = low + ((high-low)>>1);
            if(numbers[middle]<numbers[high]){
                high = middle;
            }else  if(numbers[middle] > numbers[high]){
                low = middle+1;
            }else {
                high= high-1;
            }
        }
        return numbers[low];
    }

    public char firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}
