package com.ellen.datastruct.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Order {

    //前序遍历
    public List<BinaryTree.Node> preOrder(BinaryTree.Node root){
        ArrayList<BinaryTree.Node>  list =new ArrayList();
        Deque<BinaryTree.Node> stack = new LinkedList<>();

        if(root==null){
            return null;
        }

        BinaryTree.Node node = root;
        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                list.add(node);
                stack.push(node);
                node = node.left;
            }
            node =  stack.pop();
            node = node.right;
        }
        return list;
    }

    public List<BinaryTree.Node> inOrder(BinaryTree.Node root){
        ArrayList<BinaryTree.Node>  list =new ArrayList();
        Deque<BinaryTree.Node> stack = new LinkedList<>();
        if(root==null){
            return null;
        }
        BinaryTree.Node node = root;
        while (!stack.isEmpty() || node!=null){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node =  stack.pop();
            list.add(node);//中序
            node = node.right;
        }
        return list;

    }


    public List<BinaryTree.Node> postOrder(BinaryTree.Node root){
        ArrayList<BinaryTree.Node>  list =new ArrayList();
        Deque<BinaryTree.Node> stack = new LinkedList<>();
        if(root==null){
            return null;
        }
        BinaryTree.Node prev = null;

        while (!stack.isEmpty()|| root!=null){
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(root.right==null || root.right == prev){
                list.add(root);
                prev=root;
                root = null;
            }else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }


}
