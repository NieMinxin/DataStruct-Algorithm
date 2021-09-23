package Algorithm.offer;


import com.ellen.datastruct.Hash.Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Demo01 {

    public int findRepeatNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else {
                map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            }
        }
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){
           if(entry.getValue()>1){
               return entry.getKey();
           }
       }
       return -1;
    }


    public int findRepeat(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num:nums){
            if(!set.add(num)){
                repeat=num;
                break;
            }
        }
        return repeat;
    }

    public int binarySearch(int[] a, int value) {
        int low = 0;
        int high = a.length-1;

        while (low<=high){
            int middle = low+((high-low)>>1);
            if(a[middle]>value){
                high = middle-1;
            }else if(a[middle]<value){
                low = middle+1;
            }else {
                if(middle==0 || a[middle-1]!=value){
                    return middle;
                }else {
                    high = middle-1;
                }
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int result = 0;
        int index = binarySearch(nums,target);//查找第一个等于target的 数组索引
        if(index!=-1){
            result ++;
        }
        for (int i = index; i <nums.length-1 ; i++) {
            if(nums[i+1]==target){
                result++;
            }else {
                break;
            }
        }
        return result;
    }


    public int missingNumber(int[] nums) {

        int low =0;
        int high = nums.length-1;
        while (low<=high){
            int middle = (low+high)>>1;
            if(nums[middle]==middle){
                low = middle+1;
            }else {
                high = middle-1;
            }
        }

        return  low;
    }



    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if(matrix[i][j]==target){
                    return true;
                }else {
                    return false;
                }
            }
        }
        return false;
    }




    





}
