package solution.ch01;

import Algorithm.ListNode;
import Algorithm.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Demo04 {
    public static void main(String[] args) {

    }


    public TreeNode searchBST(TreeNode root, int val) {
       //1 .递归
        //2.迭代
        /*Queue<TreeNode>  queue = new LinkedList<>();
        if(root==null){
            return null;
        }else {
            queue.offer(root);
        }
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.val==val){
                return node;
            }else {
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
        }
        return null;*/

        if(root==null || root.val==val) return root;
        return val < root.val ? searchBST(root.left,val) : searchBST(root.right,val);


    }

    //二叉树的插入算法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode newNode = new TreeNode(val);
        if(root==null){
            root = newNode;
        }else {
            TreeNode parent = find(val,root);
            if(val>parent.val){
                parent.right = newNode;

            }else {
                parent.left = newNode;

            }
        }
        return root;
    }

    public  TreeNode find(int key,TreeNode root){
        if(root==null){return null;}
        TreeNode cur = root;

        while (root!=null){
            if(key>root.val){
                if(cur.right==null) return cur;
                cur = cur.right;
            }else if(key<root.val){
                if(cur.left==null) return cur;
                cur = cur.left;
            }else {
                //key == cur
                return cur;
            }
        }
        return null;
    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA;
        ListNode l2 = headB;
        if(headA==null && headB==null){
            return null;
        }

        while (l1!=l2){
            l1 = (l1==null) ? headB : l1.next;
            l2 = (l2==null) ? headA : l1.next;
        }
        return l1;
    }

}
