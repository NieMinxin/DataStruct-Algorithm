package com.ellen.datastruct.Tree;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class AvlTree {
    private Node root;

    //Node节点
    private class Node {
        private int key;
        private int balance;
        private int height;//高度
        private Node left, right, parent;

        //构造器
        Node(int k, Node p) {
            key = k;
            parent = p;
        }
    }


    //返回节点的高度
    private int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    private  void setBalance(Node ... nodes){
        for (Node node:nodes){
            node.balance = height(node.right)-height(node.left);//设置节点的平衡度  平衡因子 0，1，-1
        }
    }

    //重新设置一个节点的高度，选择最高的子树
    private void reHeight(Node node){
        if(node!=null){
            node.height = 1 + Math.max(height(node.left),height(node.right));
        }

    }


    private Node rotateLeft(Node cur){
        Node b = cur.right;
        b.parent = cur.parent;

        cur.right = b.left;
        //旋转节点的左子树挂载父节点的右子树
        if(cur.right!=null) {
            cur.right.parent =cur;
        }
        b.left = cur;
        cur.parent = b;

        if(b.parent!=null){
            //判断旋转节点的父节点 是在父节点的左子树还是右子树
            if(b.parent.right == cur){
                b.parent.right = b;
            }else
                b.parent.left = b;
        }
        setBalance(cur,b);
        return b;//最后返回旋转节点的值
    }


    private Node rotateRight(Node cur){
        Node b = cur.left;
        b.parent = cur.parent;

        cur.left = b.right;
        //旋转节点的左子树挂载父节点的右子树
        if(cur.left!=null) {
            cur.left.parent =cur;
        }
        b.right = cur;
        cur.parent = b;

        if(b.parent!=null){
            //判断旋转节点的父节点 是在父节点的左子树还是右子树
            if(b.parent.right == cur){
                b.parent.right = b;
            }else
                b.parent.left = b;
        }
        setBalance(cur,b);
        return b;//最后返回旋转节点的值
    }


    private Node rotateLeftThenRight(Node node){
        node.left = rotateLeft(node.left);
        return rotateRight(node);
    }

    private Node rotateRightThenLeft(Node node){
        node.right = rotateRight(node.right);
        return rotateLeft(node);//左旋将右子节点
    }

    //node.balance = height(node.right)-height(node.left);
    private void reBalance(Node node){
        setBalance(node);//设置一个节点平衡因子
        if(node.balance==-2){
            //节点的左子树的高度高于右子树 需要有旋
            if(height(node.left.left)>=height(node.left.right)) node = rotateRight(node);//重新指向平衡的节点
            else node = rotateLeftThenRight(node);
        }else if(node.balance==2){
            if(height(node.right.right)>=height(node.right.left)) node = rotateLeft(node);
            else node= rotateRightThenLeft(node);
        }
        //传进来的节点发生变化，变化为旋转后的pivot
        if(node.parent!=null){
            reBalance(node.parent);
        }else {
            root = node;
        }
    }

    public  boolean insert(int key){
        //new node 每一个新节点都要初始化平衡因子

        if (root==null){
            root = new Node(key,null);;//为根节点

        }else {
            Node node =  root;
            Node parent;
            //这个循环用来找到一个可以插入的地方，如果有相同的元素直接返回false
            while (true){
                if(node.key==key) return false;//已经包含该元素
                parent = node;
                //判断往那个方向走，如果大于就往右
                // 用parent指向保留前一个结点，作为 旋转的节点
                boolean goLeft = node.key>key;
                node = goLeft? node.left : node.right;

                //如果节点为空就开始插入 并且判断旋转
                if(node==null){
                    if(goLeft){
                        parent.left = new Node(key,parent);

                    }else {
                        parent.right = new Node(key,parent);
                    }
                    reBalance(parent);
                    break;
                }

            }
        }
        return true;
    }


    //delete
    public  void delete(int key){
        if(root==null){return;}
        Node node = root;
        Node parent =root;
        while (node!=null){
            parent = node;//parent 指向上一个节点
            node = key >= node.key ? node.right : node.left;//node继续枚举
            if(key== node.key){
                delete(parent);
                return;
            }
        }

    }


    //删除算法就是找到相应要删除的节点，然后，将这个节点，左右子树中的某个节点替换这个节点的key
    /*
    如果是左子树 就把左子树的最大一个右叶子节点的值换掉，然后删掉
    右子树 就把最小的左叶子节点换掉，然后删除掉这个叶子节点
    * */
    private void delete(Node node){
        if(node.left==null && node.right==null){
            //为叶节点
            if(node.parent==null) root=null;//为root节点
            else {
                Node parent= node.parent;
                //左节点
                if(parent.left==node){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
                reBalance(parent);

            }
            return;
        }
        if(node.left!=null){
            Node child =node.left;

            while (child.right!=null){
                child = child.right;
            }
            node.key = child.key;
            delete(child);
        }else {
            Node child = node.right;
            while (child.left!=null){
                child = child.left;
            }
            node.key = child.key;
            delete(child);
        }
    }



    //遍历
    public void print(){
        printBalance(root);
    }




    private  void printBalance(Node root){
        if(root!=null){

            printBalance(root.left);
            printBalance(root.right);
            System.out.println("key:"+root.key);
        }
    }


}
