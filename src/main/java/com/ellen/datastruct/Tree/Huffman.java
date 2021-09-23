package com.ellen.datastruct.Tree;

import com.ellen.datastruct.Heap.MinPriorityQueue;

public class Huffman {

    //节点
    private class HuffmanNode implements Cloneable,Comparable<HuffmanNode>{

        private int key;
        protected HuffmanNode left;
        protected HuffmanNode right;
        protected HuffmanNode parent;

        @Override
        public int compareTo(HuffmanNode o) {
            return this.key-o.key;
        }
        HuffmanNode(int key,HuffmanNode left,HuffmanNode right,HuffmanNode parent){
            this.key = key;
            this.right = right;
            this.left = left;
            this.parent = parent;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "HuffmanNode{" +
                    "key=" + key +
                    '}';
        }
    }


    private HuffmanNode root;

    public Huffman(int []array){
        HuffmanNode parent = null;
        MinPriorityQueue queue = new MinPriorityQueue(array.length);
        //将数据添加到最小堆中
        for (int i = 0; i <array.length; i++) {
            queue.insert(array[i]);
        }

        for (int i = 0; i < array.length-1; i++) {
            int leftValue = queue.delete();
            HuffmanNode left = new HuffmanNode(leftValue,null,null,null);
            int rightValue = queue.delete();
            HuffmanNode right = new HuffmanNode(rightValue,null,null,null);
            parent = new HuffmanNode(leftValue+rightValue,left,right,null);
            left.parent=parent;
            right.parent=parent;
            // 将parent节点数据拷贝到"最小堆"中
            queue.insert(parent.key);

        }
        root = parent;

        queue.clear();
    }

    public void destroy() {
        if(root==null){
            return;
        }else {
            root=null;
        }
    }






}
