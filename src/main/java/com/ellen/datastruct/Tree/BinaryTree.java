package com.ellen.datastruct.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {


    private  Node root;//根节点

    public BinaryTree(){
        root =null;
    }




    public class Node {
        public int data;
        //左儿子
        public Node left;
       //右儿子
        public Node right;
        //父亲节点
        public Node parent;

    public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    //返回根节点
    public Node getRoot() {
        return root;
    }
    //找到指定值的节点,如果找不到，返回父节点
    public Node find(int key){
        if(root==null){
            return null;
        }
        Node current = root;
        while (current!=null){
            if(key<current.data){
                if(current.left==null) return current;// 返回父节点
                current = current.left;
            }else if(key>current.data){
                if(current.right==null) return current;
                current = current.right;
            }else {
                return current;//key==current.data;
            }
        }
        //doesn't find key
        return null;
    }


    //删除节点时我们把右子树下的最小元素拿上来作为新的节点补充在删除的节点上
    private   Node findSuccessor(Node node){
        if(node==null){return null;}
        //没有右节点
        if(node.right==null){
            return node;
        }
        Node parent = node.right;
        Node cur = node.right;
        while (cur!=null){
            parent = cur;
            cur= cur.left;
        }
        return parent;
    }

    //插入节点
    public void put(int value){
        Node newNode = new Node(value);
        if(root==null){
            root = newNode;
        }else {
            Node parent = find(value);//找到插入位置的父节点
            if(value>parent.data){
                parent.right=newNode;
                parent.right.parent=parent;
                return;
            }else {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            }
        }

    }


    public  boolean remove(int value){

        Node tmp = find(value);//找到要删除的节点
        //，如果没找到返回父节点
        if(tmp.data!=value) return false;//value 不存在

        // No children ,返回的是父类的节点
        if(tmp.right ==null && tmp.left==null){
            //为根节点
            if(tmp==root){
                root =null;
            }else if(tmp.parent.data<tmp.data){
                tmp.parent.right=null;
            }else {
                tmp.parent.left=null;
            }
            return true;
        }

        //twoChild
        else if(tmp.left!=null && tmp.right!=null) {
            Node successor = findSuccessor(tmp);
            //找到替代删除的那个节点之后
            successor.left = tmp.left;
            successor.left.parent = successor;


            //successor 的 父节点 为不tmp 处理情况
            if (successor.parent != tmp) {
                //右子树不为空
                if (successor.right != null) {
                    successor.right.parent = successor.parent;
                    successor.parent.left = successor.right;
                    successor.right = tmp.right;
                    tmp.right.parent = successor;
                    return true;
                } else {
                    //右子树为空
                    successor.parent.left = null;
                    successor.right = tmp.right;
                    successor.right.parent = successor;
                    return true;
                }

            }

            if (tmp == root) {
                successor.parent = null;
                root = successor;
                return true;
            } else {
                successor.parent = tmp.parent;
                if (tmp.data < tmp.parent.data) {
                    tmp.parent.left = successor;
                } else
                    tmp.parent.right = successor;
                return true;
            }
            }

            //one child
            else {
                //只有右子树
                if(tmp.right!=null){
                    //为根节点
                    if(tmp==root){
                        root=tmp.right;
                        return true;
                    }

                    tmp.right.parent = tmp.parent;
                    //判断tmp是在左子树，还是右子树
                    if(tmp.data<tmp.parent.data) tmp.parent.left = tmp.right;
                    else tmp.parent.right = tmp.right;
                    return true;
                }
                //只有左子树
                else {
                    if(tmp==root){
                        root = tmp.left;
                        return true;
                    }
                    tmp.left.parent = tmp.parent;
                    if(tmp.data>tmp.parent.data) tmp.parent.left = tmp.left;
                    else tmp.parent.right = tmp.left;
                    return true;
                }

            }
        }


        //前序便利
        //中序便利
        //后序便利
        public void inOrder(Node node){
            if(node!=null){
                inOrder(node.left);
                System.out.println("data:"+node.data+"->");
                inOrder(node.right);
            }
        }

        public void preOrder(Node node){
            if(node!=null){
                System.out.println("data:"+node.data+"->");
                preOrder(node.left);
                preOrder(node.right);
            }
        }

        public void postOrder(Node node){
            if(node!=null){
                postOrder(node.left);
                postOrder(node.right);
                System.out.println("data:"+node.data+"->");
            }
        }


        //根左右
        public List<Integer> preOrderWithStack(Node node){
            Deque<Node> stack = new LinkedList<>();
            List<Integer> list  = new ArrayList<>();

            if(node==null){
                return list;
            }
            while (node!=null || !stack.isEmpty()){
                while (node!=null){
                    stack.push(node);
                    list.add(node.data);
                    node = node.left;
                }
                node = stack.pop();
                node = node.right;
            }
            return list;
        }

    //左根右
    public List<Integer> inOrderWithStack(Node node){
        Deque<Node> stack = new LinkedList<>();
        List<Integer> list  = new ArrayList<>();

        if(node==null){
            return list;
        }
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);

                node = node.left;
            }
            node = stack.pop();
            list.add(node.data);
            node = node.right;
        }
        return list;
    }

    //左右根
    public List<Integer> postOrderWithStack(Node node){

        List<Integer> list  = new ArrayList<>();
        if(node==null){
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        Node pre = null;
        while (node!=null || !stack.isEmpty()){
            while (node!=null){
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if(node.right==null || node.right==pre){
                list.add(node.data);
                pre= node;
                node = null;
            }else {
                stack.push(node);
                node = node.right;
            }
        }
        return list;
    }






    //统计树中节点个数

    public int countNodes(Node root) {
        return 0;
    }





    }




