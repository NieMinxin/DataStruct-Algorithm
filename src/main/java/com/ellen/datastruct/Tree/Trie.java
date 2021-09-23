package com.ellen.datastruct.Tree;

import java.util.Arrays;

public class Trie {

    private class Node{
        Node[] child;//子节点
        boolean end;//是否时某个单词的结束

        Node(){
            child = new Node[26];//最多26个字符
            end = false;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "child=" + Arrays.toString(child) +
                    '}';
        }
    }

    private Node root;

    public Trie(){
        root = new Node();
    }

    public void insert(String word){
        Node cur = this.root;//根节点
        for (int i = 0; i < word.length(); i++) {
            //每个字符拆分
            Node node = cur.child[word.charAt(i)-'a'];
            if(node==null){
                node = new Node();//如果时空，就插入这个字符
                cur.child[word.charAt(i)-'a'] = node;
            }
            cur = node;//如果不为空，cur 就等于这个节点，继续插入下一个字符
        }
        cur.end = true;
    }


    public boolean search(String word){
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = cur.child[ch-'a'];
            if(node==null){
                return false;
            }
            cur = node;//下一个字符为这个节点子节点，继续寻找
        }

        return false;
    }

    public static boolean isValid(String word) {
        return word.matches("^[a-z]+$");//正则表达式  ^ $开头和结尾
    }


    public static void sop(String print) {
        System.out.println(print);
    }

    public boolean delete(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            Node node = cur.child[ch-'a'];
            if(node==null){
                return false;
            }
            cur = node;
        }
        if (cur.end==true){
            cur.end = false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Trie{" +
                "root=" + root +
                '}';
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("hello");


    }
}
