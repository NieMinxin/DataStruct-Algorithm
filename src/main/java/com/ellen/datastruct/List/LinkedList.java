package com.ellen.datastruct.List;

import java.util.StringJoiner;

public class LinkedList {
    //Node 节点
    class Node {
        int value;
        Node next;
        Node() {
        }
        Node(int value) {
            this(value, null);
        }
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node head;
    private  int len;
    public int getLen() {
        return len;
    }
    //初始化
    LinkedList(){
        head=null;
        len=0;
    }

    //头插
    public void insertHead(int value) {
        insertIndex(value,0);
    }
    //在为末尾插入
    public void insert(int value) {
        insertIndex(value,len);
    }

    public void insertIndex(int value,int index) {
        //头节点 index 为 1
        Node node = new Node(value);

        if(head==null){
            head=node;
            len++;
            return;
        } else if(index==0){
            node.next = head;//head 为头节点指向的内存空间
            head = node;
            len++;
            return;

        }
        Node cur = head;
        for (int i = 0; i <index-1; i++) {
            cur = cur.next;
        }
        //便利找到前置节点
        node.next= cur.next;
        cur.next = node;//
        this.len++;
    }

    //打印函数
    public  String print() {
        Node cur = this.head;
        StringBuilder stringBuilder = new StringBuilder();
        while (cur!=null){
            stringBuilder.append(cur.value );
            stringBuilder.append("->");
            cur = cur.next;
        }
        return stringBuilder.toString();
    }

    public boolean isEmpty(){
        return len==0;
    }

    public int getIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node= node.next;
        }
        return node.value;
    }

    public void clear() {
        Node cur =head;
        while (cur!=null){
            Node pre = cur;
            cur = cur.next;
            pre =null;
        }
        len=0;
        head=null;
    }

    public void deleteIndex(int index) {
        if(index==0){
            Node destroy = head;
            head = head.next;
            destroy = null;//GC
            len--;
            return;
        }
        Node cur = head;

        for (int i = 0; i < index-1; i++) {
            cur = cur.next;//找到前置的节点
        }
        Node des = cur.next;
        cur.next = cur.next.next;//核心
        des=null; //help GC

        len--;

    }

    public  void delete(){
        deleteIndex(len-1);

    }

    public  void deleteHead(){
        deleteIndex(0);
    }

}
