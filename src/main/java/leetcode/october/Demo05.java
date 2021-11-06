package leetcode.october;

import Algorithm.ListNode;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

public class Demo05 {


    //杨辉三角
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <=rowIndex; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                if(j==0 || j==i){
                    list.add(1);
                }else {
                    list.add(lists.get(i - 1).get(j - 1) + lists.get(i - 1).get(j));
                }
            }
            lists.add(list);
        }
        return lists.get(rowIndex);
    }


    //滚动数组
    public List<Integer> getRow_copyI(int rowIndex){
        List<Integer> pre = new ArrayList<Integer>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j-1)+pre.get(j));
                }
            }
            pre = cur;
        }
        return pre;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        boolean isCarry = false;
        while (l1!=null && l2!=null){
            int num = l1.val+ l2.val;
            if(isCarry){
                num = num + 1;
                isCarry = false;
            }
            if(num>=10){
                num = num-10;
                isCarry = true;
            }
            ListNode node = new ListNode(num);
            l1 = l1.next;
            l2 = l2.next;
            head.next = node;
            head = head.next;
        }
        ListNode cur = (l1==null) ? l2:l1;
        while (cur!=null){
            int num = cur.val;
            if(isCarry){
                num=num+1;
                isCarry = false;
            }
            if(num>=10){
                num=num-10;
                isCarry=true;
            }
            ListNode node = new ListNode(num);
            head.next = node;
            head = head.next;
        }
        return dummy.next;
    }


    public void rotate(int[][] matrix) {
            int n = matrix.length;
            int[][] matrix_new = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix_new[j][n - i - 1] = matrix[i][j];
                }
            }
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    matrix[i][j] = matrix_new[i][j];
                }
            }

    }

    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num<=tar){
            for (int i = 1; i <=r ; i++){
                mat[t][i] = num++;
            }
            t++;//从左到右
            for (int i = t; i <=b ; i++) {
                mat[i][r] = num++;
            }//从上到下
            r--;
            for (int i = r; i >=l ; i--) {
                mat[b][i] = num++;
            }//右到左
            b--;
            for (int i = b; i >=t ; i--) {
                mat[i][l] = num++;
            }
            l++;

        }
        return mat;
    }

    //二分查找 二维数组
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int arr[]:matrix
             ) {
            int index = binarySearch(arr,target);
            if(index>=0){
                return true;
            }

        }
        return false;
    }

    public int binarySearch(int nums[], int target){
        int low =0,high = nums.length -1;
        while (low<=high){
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid+1;
            }

        }
        return -1;
    }







}
