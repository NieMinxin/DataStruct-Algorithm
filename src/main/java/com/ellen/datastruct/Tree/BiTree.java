package com.ellen.datastruct.Tree;

import Algorithm.TreeNode;

import java.util.*;

public class BiTree {

    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length ; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,preorder.length-1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left>right){
            return null;//递归终止条件，
        }
        TreeNode node = new TreeNode(preorder[root]);//创建新的节点
        int i = dic.get(preorder[root]);
        node.left = recur(root+1,left,i-1);
        node.right = recur(root+i-left+1,i+1,right);
        return node;
    }


    public List<Integer> postOrderWithStack(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre =null;
        while (root!=null || !stack.isEmpty()){

            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();

            if(root.right==null || root.right==pre){
                list.add(root.val);
                pre = root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BiTree biTree = new BiTree();
        TreeNode root = biTree.buildTree(new int[]{3,9,2,1,7},new int[]{9,3,1,2,7});
        System.out.println(biTree.postOrderWithStack(root));
    }
}
