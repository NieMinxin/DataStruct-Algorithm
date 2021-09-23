package Algorithm;

import java.util.*;

public class Demo03 {
    //有效的括号
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList();
        if(s.length()% 2==1){
            return false;
        }
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put('}','{');
        pairs.put(']','[');
        pairs.put(')','(');
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i);
            if(pairs.containsKey(c)){
                if(stack.isEmpty() || stack.peek()!=pairs.get(c)){
                    return false;
                }
                //满足括号匹配，弹栈
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> lists = new ArrayList<>();

        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <=currentLevelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
            }
            lists.add(list);

        }
        return lists;
    }


    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }


    public int maxValue(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row + 1][col+1];

        for (int i = 1; i <=row; i++) {
            for (int j = 1; j <=col; j++) {
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) + grid[i-1][j-1];
            }
        }
        return dp[row][col];
    }

    /*public int maxValue(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(i==0 && j==0) continue;
                if(i==0) grid[i][j] += grid[i][j-1];//仅为一行
                else if(j==0) grid[i][j] += grid[i-1][j];//仅为一列
                else grid[i][j] += Math.max(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[row-1][col-1];
    }*/

    //暴力循环
    //双指针
    public int[] twoSum(int[] nums, int target) {
        int i=0,j=nums.length;
        while (i<j){
             if(nums[i]+nums[j]<target){
                i++;
            }else if(nums[i]+nums[j]>target){
                j--;
            }else {
                 return new int[]{nums[i],nums[j]};
             }
        }

        return new int[0];
    }





    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if(k == word.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }


}


