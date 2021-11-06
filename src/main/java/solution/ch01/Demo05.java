package solution.ch01;

import Algorithm.ListNode;

import java.util.*;

public class Demo05 {
    public boolean containsDuplicate(int[] nums){
        quickSort(nums,0, nums.length-1);

        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1]){
                return true;
            }
        }
        return  false;
    }

    protected   int[] quickSort(int nums[],int left ,int right){
        if(left<right){
            int pivot = nums[left];
            int low = left;
            int high = right;
            while(low<high){
                while(low<high && nums[high]>=pivot){
                    high--;
                }
                nums[low] = nums[high];
                while (low<high && nums[low]<=pivot){
                    low++;
                }
                nums[high] = nums[low];
            }
            nums[low] = pivot;
            quickSort(nums,left,low-1);
            quickSort(nums,low+1,right);
        }
        return nums;
    }

    public int maxSubArray(int[] nums){

        int max = nums[0];
        int pre =0;
        for (int i = 0; i < nums.length; i++) {
            pre = Math.max(pre+nums[i],nums[i]);
            max = Math.max(pre,max);
        }
        return max;
    }


    public static int[] twoSum(int[] nums, int target){
        Hashtable<Integer,Integer> hashtable = new Hashtable();
        for (int i = 0; i < nums.length; i++) {
            if(hashtable.contains(target-nums[i])){
                return  new int[]{hashtable.get(target-nums[i]),i};
            }else {
                hashtable.put(nums[i],i);
            }
        }
        return new int[0];//返回一个空数组
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n){
        int sorted[] = new int[m+n];
        int p0=0,p1=0;
        int tmp;
        while (p0<m || p1<n){
            if(p0==m){
                tmp = nums2[p1++];
            }else if(p0==n){
                tmp = nums1[p0++];
            }else if(nums1[p0]>nums2[p1]){
                tmp = nums2[p1++];
            }else {
                tmp = nums1[p0++];
            }

            sorted[p0+p1-1] = tmp;
        }
        return sorted;
    }

    private boolean isEven(int length){
        return length%2==0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double middle = 0.0;
        int n1 = nums1.length,n2 = nums2.length;
        if(nums1.length==0){
            if(isEven(nums2.length)){
                middle = (nums2[n2/2]+nums2[n2/2-1])/2;
            }else {
                middle = nums2[(int) Math.floor(n2/2)];
            }
        }else if(nums2.length==0){
            if(isEven(nums1.length)){
                middle = (nums1[n2/2]+nums1[n2/2-1])/2;
            }else {
                middle = nums1[(int) Math.floor(n2/2)];
            }
        }else {
            int array[] = new int[n1+n2];
            array = merge(nums1,n1,nums2,n2);
            if(isEven(array.length)){
                middle = (array[n2/2]+array[n2/2-1])/2;
            }else {
                middle = array[(int) Math.floor(n2/2)];
            }

        }
        return  middle;
    }


    public int maxArea(int[] height) {
        int maxArea = 0;
        int i=0,j=height.length-1;
        while (i<j){
            if(height[i]<height[j]){
                maxArea = Math.max(maxArea,(j-i)*height[i++]);
            }else {
                maxArea = Math.max(maxArea,(j-i)*height[j--]);
            }
        }
        return maxArea;
    }

    public  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        int len = nums.length;
        if(len<3 || nums ==null){
            return  lists;
        }
        for (int i = 0; i < len; i++) {
            if(nums[0]>0) break;
            if(i>0 && nums[i]==nums[i-1]) continue;

            int l = i+1,r=len-1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum==0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    lists.add(list);
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while (l<r && nums[r]==nums[r-1]) r--;
                    l++;
                    r--;
                }else if(sum>0) r--;
                else if(sum<0) l++;
            }
        }
        return lists;
    }

    public boolean isValid(String s) {
        if(s.length()%2==1){
            return false;
        }
        LinkedList<Character> stack = new LinkedList<>();
        HashMap<Character,Character> pair = new HashMap<>();
        pair.put('}','{');
        pair.put(']','[');
        pair.put(')','(');

        for (int i = 0; i <s.length() ; i++) {
            char ch = s.charAt(i);
            if(pair.containsKey(ch)){
                if(stack.isEmpty() || stack.peek()!=pair.get(ch)){
                    return false;
                }
                stack.pop();
            }else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>  map  = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer,Integer> e: map.entrySet()
        ) {
            if(e.getValue()>nums.length/2){
                return e.getKey();
            }
        }
        return -1;
    }
    //leetcode -18
    public int threeSumClosest(int[] nums, int target) {
        int close=nums[0]+nums[1]+nums[2];
        int len = nums.length;
        if(len<3 || nums==null){
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i+1;
            int r = len-1;
            while (l<r){
                int sum  = nums[i]+nums[l]+nums[r];
                if(sum==target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(close - target)) {
                    close = sum;
                }
                if(sum>target){
                    int r0 = r-1;
                    // 移动到下一个不相等的元素
                    while (l<r0 && nums[r0]==nums[r]){
                        r0--;
                    }
                    r = r0;
                }else {
                    int l0 = l+1;
                    while (l0<r && nums[l0]==nums[l]){
                        l0++;
                    }
                    l = l0;
                }
            }
        }
        return close;
    }

    //leetcode-26
    public int removeDuplicates(int[] nums) {
        if(nums.length==0 || nums==null){
            return 0;
        }
        int i = 1,j=1;
        while (j< nums.length){
            if(nums[j]!=nums[j-1]){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
    //leetcode-28
    public int removeElement(int[] nums, int val) {
        int i = 0,j=0;
        while (j< nums.length){
            if(nums[j]!=val){
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }

    public int[] intersect(int[] nums1, int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;//双指针
        int index =0;
        int len1=nums1.length,len2=nums2.length;
        int result[] = new int[Math.min(len1,len2)];
        while (i<len1 || j<len2){
            if(nums1[i]>nums2[j]){
                result[index++] = nums2[j];
                j++;
            }else if(nums1[i]<nums2[j]){
                result[index++] = nums1[i];
                i++;
            }else {
                result[index++]=nums1[i];
                i++;
                j++;
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    public int[][] matrixReshape(int[][] mat, int r, int c){
        if(r*c!=mat.length*mat[0].length){
            return mat;
        }
        int res[][] = new int[r][c];
        int row =0,col=0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j <mat[0].length; j++) {
                res[row][col] = mat[i][j];
                if(col==c-1){
                    row++;
                    col=0;
                }else {
                    col++;
                }
            }
        }
        return res;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null){
            return head;
        }
        int n = 1;//计算链表的长度
        ListNode cur = head;
        while(cur.next!=null){
            cur = cur.next;
            n++;//  len = n-1
        }
        int add = n-(k%n);//用来记录新链表的前置节点
        if(add==n){
            return head;
        }
        cur.next = head;//变为循环链表
        while (add-- > 0 ){
            cur = cur.next;
        }
        ListNode res = cur.next;
        cur.next = null;
        return  res;
    }
    //单指针
    /*public void sortColors(int[] nums) {
        int ptr = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==0){
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
        for (int i = ptr; i <nums.length; i++) {
            if(nums[i]==1){
                int tmp = nums[i];
                nums[i] = nums[ptr];
                nums[ptr] = tmp;
                ptr++;
            }
        }
    }*/
    //双指针
    public void sortColors(int[] nums) {
        int len=nums.length;
        int p0 = 0,p2 =len-1;
        for (int i = 0; i < len; i++) {
            while (i<=p2 && nums[i]==2){
                int tmp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = tmp;
                p2--;
            }
            if(nums[i]==0){
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                ++p0;
            }
        }
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n<=0 || head==null){
            return head;
        }
        ListNode dummy = new ListNode(0,head);
        ListNode fast=head,slow= dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast!=null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        ListNode res = dummy.next;
        return res;
    }*/

    //栈
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0,head);
        Deque<ListNode> stack = new LinkedList<>();
        ListNode cur = dummy;
        while (cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        for (int i = 0; i < n; ++i) {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next =  prev.next.next;
        ListNode res = dummy.next;
        return  res;
    }

    //合并K个链表  ，给你一个链表数组，每个链表都已经按升序排列
    //四中解法
    public ListNode mergeKLists(ListNode[] lists) {

        return null;
    }

    public void setZeroes(int[][] matrix){
        boolean rows[] = new boolean[matrix.length];
        boolean cols[] = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    rows[i]=true;
                    cols[j] =true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {
                if(rows[i] || cols[j]){
                    matrix[i][j]=0;
                }
            }
        }
    }

    int c =0;

    //递归汉诺塔
    public void hanoi(int n,char x,char y,char z){
        if(n==1){
            move(x,1,z);
        }else {
            hanoi(n-1,x,z,y);//x 上面的 n-1个 通过 z移动到y
            move(x,n,z);//x -> z
            hanoi(n-1,y,x,z);// y上面的 n-1 个通过 x 移动到z
        }
    }

    private void move(char x,int n,char z){
        System.out.println("第"+ c++ +"次操作"+ n +"号盘" + x + "->" + z);
    }


    public  static  String  twoSum(String a,String b){
        if(a==null || b==null){
            return null;
        }

        Deque<Character> stackSum  = new LinkedList<>();
        Deque<Character> s1 = new LinkedList<>();
        Deque<Character> s2 = new LinkedList<>();
        boolean isCarry = false;
        int partialSum;

        for (int i = 0; i <a.length(); i++) {
            char ch = a.charAt(i);

            s1.push(ch);
        }

        for (int i = 0; i <b.length(); i++) {
            char ch = a.charAt(i);
            s2.push(ch);
        }


        while (!s1.isEmpty() && !s2.isEmpty()){
            partialSum = Integer.parseInt(String.valueOf(s1.pop())) + Integer.parseInt(String.valueOf(s2.pop()));
            if(isCarry){
                partialSum++;
                isCarry = false;
            }
            if(partialSum>=10){
                partialSum-=10;
                stackSum.push((char) ('0'+partialSum));//把数字转化为字符
                isCarry=true;
            }else {
                stackSum.push((char) ('0'+partialSum));
            }
        }
        Deque<Character> tmp = !s1.isEmpty() ? s1 : s2;

        while (!tmp.isEmpty()){
            if(isCarry){
                int t = Integer.parseInt(String.valueOf(tmp.pop()));
                ++t;//进位加到此处
                if(t>=10){
                    t-=10;
                    stackSum.push((char) ('0'+t));
                    isCarry=true;
                }else {
                    stackSum.push((char) ('0'+t));
                    isCarry = false;
                }
            }else {
                stackSum.push(tmp.pop());
            }
        }

        if(isCarry){
            stackSum.push('1');//最高位
        }
        StringBuilder sb = new StringBuilder();
        while (!stackSum.isEmpty()){
            sb.append(stackSum.pop());
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        //System.out.println(twoSum("111111111111","11111"));

        Demo05 demo = new Demo05();
        demo.hanoi(10,'x','y','z');
    }


}
