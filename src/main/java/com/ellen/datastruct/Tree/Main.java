package com.ellen.datastruct.Tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.put(10);
        binaryTree.put(8);
        binaryTree.put(11);
        binaryTree.inOrder(binaryTree.getRoot());


        AvlTree avlTree = new AvlTree();
        for (int i = 3; i <10 ; i++) {
            avlTree.insert(i);
        }

        avlTree.print();
    }
}
