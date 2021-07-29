package com.ellen.datastruct.List;

public class DoubleLinkedList {
    //node 节点
    class Node {
        public int value;
        public Node next;//后节点
        public Node previous;//前节点
        public Node(int value) {
            this.value = value;
            next=null;
            previous=null;
        }

        public void print() {
            System.out.println("value:"+value);
        }
    }

    private Node head;
    private Node tail;
    private  int size;

    //初始化
    public DoubleLinkedList(){
        head=null;
        tail=null;
        this.size=0;

    }

    public int len() {
        return size;
    }

    public boolean isEmpty() {
        return head==null;
    }

    public void display() {
        Node current = head;
        while (current!=null){
            current.print();
            current=current.next;
        }
        System.out.println();
    }
    /** Clears List */
    public void clearList() {
        head = null;
        tail = null;
        size = 0;
    }

    //插入头节点
    public void insertHead(int value) {
        Node newNode = new Node(value);
        if (newNode==null){
            return;
        }
        if(isEmpty()){
            head=newNode;//
            tail=head;

        }else {
            head.previous=newNode;
            newNode.next = head;
            head=newNode;

        }
        size++;

    }

    //插入尾节点
    public void insertTail(int value) {
        Node newNode = new Node(value);
        if(head==null){
            tail=newNode;
            head=tail;
        }else {
            tail.next=newNode;
            newNode.previous=tail;
            tail = newNode;//newNode 此时为尾节点
        }
        ++size;
    }

    public void insertEleByIndex(int index,int value) {
        Node newNode = new Node(value);
        if(index>size){ throw new ArrayIndexOutOfBoundsException(); }
        if(index==0){
            insertHead(value);
        }else {
            if(index==size){
                insertTail(value);
            }else {
                //核心算法
                Node current  = head;

                for (int i = 0; i <index-1 ; i++) {
                    current=current.next;
                }
                newNode.next=current.next;//插入节点指向 前置节点的next；
                current.next.previous = newNode;//前置节点的next 的头指针指向 插入的新节点
                current.next = newNode;
                newNode.previous = current;
            }

        }
        ++size;
    }


    public Node deleteHead() {
        if(head==null){
            return null;
        }
        Node tmp = head;
        head =  head.next;
        if(head==null){
            tail = null;//就一个节点
        }else {
            head.previous = null;
        }
        --size;
        return  tmp;//返回删除的节点
    }


    public Node deleteTail() {
        Node tmp = tail;//tmp指向 tail
        if(tail==null){
            head=null;

        }else {
            tail = tail.previous;
            tail.next=null;
        }
        --size;
        return tmp;
    }


    public void remove(int value) {
        Node current = head;

        while (current.value != value){
           //便利到尾节点
            if(current != tail){
                current = current.next;
            }
        }

        if(current == head) deleteHead();
        if(current==tail)
            deleteTail();
        else{
            current.previous.next = current.next;
            current.next.previous = current.previous;
        }
        --size;

    }

    //队列方法
    public Node getHead() {
        if(head==null)
            return null;
        else
            return head;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if(head==null){
            insertHead(value);
        }else {
            insertTail(value);
        }
    }

    public Node peek() {
        final Node first;
        if(head==null){
            return null;

        }else {
            first = deleteHead();
        }
        return first;
    }




}
