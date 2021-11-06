package com.ellen.datastruct.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


    /*
    任何数和 00 做异或运算，结果仍然是原来的数，即 a \oplus 0=aa⊕0=a。
    任何数和其自身做异或运算，结果是 00，即 a \oplus a=0a⊕a=0。
    异或运算满足交换律和结合律，即 a \oplus b \oplus a=b \oplus a \oplus a=b \oplus (a \oplus a)=b \oplus0=ba⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    * */

    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num: nums){
            single ^= num;
        }
        return single;
    }


    private void quickSort(int nums[],int left,int right){

        if(left<right){
            int pivot = nums[left];
            int low = left;
            int high = right;
            while (low<high){
                while (low<high && nums[high]>=pivot){
                    high--;
                }
                nums[low] = nums[high];
                while (low<high && nums[low]<=pivot){
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            quickSort(nums, left, low - 1);
            quickSort(nums, low + 1, right);
        }
    }

    public int majorityElement(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums[nums.length/2];
    }


    public  List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> lists = new ArrayList<>();
        if(nums.length<3 || nums==null){
            return lists;
        }
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i <len ; i++) {
            if(nums[i]>0){
                break;
            }
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int l = i + 1 ,r=len-1;
            while (l<r){
                int num = nums[i] + nums[l] + nums[r];
                if(num==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while (l<r && nums[l]==nums[l+1]){
                        l++;//去重
                    }
                    while (l<r && nums[r]== nums[r-1]){
                        r--;
                    }
                }
                else if(num>0){
                    r--;
                }else if(num<0){
                    l++;
                }

            }
        }
        return lists;
    }


    //颜色分类 双指针







}
