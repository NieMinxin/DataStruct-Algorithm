package leetcode.october;

import Algorithm.TreeNode;
import com.ellen.datastruct.Tree.BinaryTree;
import javafx.scene.transform.Scale;

import java.util.*;

public class Demo06 {

    public  static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            if (intervals[i][0] >= right) {
                ++ans;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int min = Integer.MAX_VALUE,mid = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>mid) return true;
            if(nums[i]<=min) min=nums[i];
            else mid = nums[i];
        }
        return false;
    }


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        if(s==null){
            return list;
        }
        int len = s.length();
        int letters[] = new int[26];
        for (int i = 0; i < len; i++) {
            letters[s.charAt(i)-'a'] = i;
        }

        int start=0,end =0;
        for (int i = 0; i < len; i++) {
            //贪心
            end = Math.max(end,letters[s.charAt(i)-'a']);
            if(i==end){
                list.add(end-start+1);
                start = end + 1;
            }
        }
        return list;
    }





    public static int minDepth(BinaryTree.Node root) {
        int min = 0;
        if(root==null){
            return min;
        }
        Queue<BinaryTree.Node> queue  = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {//队列不为空就继续循环
            min++;
            int levelCount = queue.size();
            for (int j = 0; j < levelCount; j++) {
                BinaryTree.Node node = queue.poll();//出队
                //如果当前node节点的左右子树都为空，直接返回level即可
                if (node.left == null && node.right == null)
                    return min;
                //左右子节点，哪个不为空，哪个加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
        }
        return -1;
    }

    public boolean wordPattern(String pattern, String str) {
        Map<String, Character> str2ch = new HashMap<String, Character>();
        Map<Character, String> ch2str = new HashMap<Character, String>();
        return false;
    }

    //贪心算法
    public int longestPalindrome(String s) {
        char count[] = new char[128];
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            count[c]++;
        }

        int res =0;
        for (int v:count
             ) {
            res = res + v/2*2;
            if(res%2==0 && v%2==1){
                res++;
            }
        }
        return res;
    }


    //构建二叉树
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) return null;                          // 递归终止
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }

}
