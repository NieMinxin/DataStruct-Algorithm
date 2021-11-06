package leetcode.october;

import Algorithm.TreeNode;

import java.util.*;

public class Demo04 {

    public TreeNode invertTree(TreeNode root){
       if(root==null){
           return null;
       }
       TreeNode left = invertTree(root.left);
       TreeNode right = invertTree(root.right);
       root.right = left;
       root.left = right;
       return root;
    }


    /*public boolean hasPathSum(TreeNode root, int targetSum){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            return root.val==targetSum;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }*/

    //广度优先搜索

    /*public int minDepth(TreeNode root) {
        int min = 0;
        if(root==null){
            return min;
        }
        Queue<TreeNode> queue  = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {//队列不为空就继续循环
            min++;
            int levelCount = queue.size();
            for (int j = 0; j < levelCount; j++) {
                TreeNode node = queue.poll();//出队
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
    }*/

    //深度优先搜索
    public int minDepth(TreeNode root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 1;
        }

        int min_depth = Integer.MIN_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }

        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }




    public boolean isValidBST(TreeNode root,Integer lower,Integer upper) {
        if(root==null){
            return true;
        }
        if(root.val<=lower || root.val>=upper){
            return false;
        }
        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
    }

    //二叉树中序遍历
    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }

    }

    // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return false;
        }
        double inorder = -Double.MAX_VALUE;
        Deque<TreeNode> stack = new LinkedList<>();
        while (root!=null || !stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.val<=inorder){
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }


        public boolean findTarget(TreeNode root, int k) {
            Set < Integer > set = new HashSet();
            Queue < TreeNode > queue = new LinkedList();
            queue.add(root);
            while (!queue.isEmpty()) {
                if (queue.peek() != null) {
                    TreeNode node = queue.remove();
                    if (set.contains(k - node.val))
                        return true;
                    set.add(node.val);
                    queue.add(node.right);
                    queue.add(node.left);
                } else
                    queue.remove();
            }
            return false;
        }



        //0、 1 和 2 分别表示红色、白色和蓝色。
        public void sortColors(int[] nums){
            int len = nums.length;
            int p0=0,p2=len-1;
            for (int i = 0; i < len; i++) {
                while (i<=p2 && nums[i]==2){
                    int tmp = nums[i];
                    nums[i] = nums[p2];
                    nums[p2] = tmp;
                    --p2;
                }
                if(nums[i]==0){
                    int tmp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = tmp;
                    ++p0;
                }
            }
        }

        //合并空间
        public int[][] merge(int[][] intervals) {
            int row = intervals.length;
            int col = intervals[0].length;

            for (int i = 1; i < row; i++) {
                int arr[] = intervals[i];
                int pre[] = intervals[i-1];

                if(arr[0]>pre[1]){
                    continue;
                }else {
                    int tmp[] = new int[]{pre[0],arr[1]};
                    intervals[i] = tmp;
                }
            }
            return intervals;
        }


}
