package com.ellen.datastruct.List;



import java.util.Scanner;


public class LinkedList {
    //Node 节点
    static class Node {
        int value;
        int score;
        Node next;
        Node() {
        }
        public Node(int id,int score){
            this(id,score,null);
        }

        public Node(int id, int score, Node next) {
            this.value = id;
            this.score = score;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" +
                    "num=" + value + "," +
                    "score="+ score +
                    ']';
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

    public void insertNode(Node t,int index) {
        insertIndex(t.value,t.score,index);
    }

    //头插
    public void insertHead(int value,int score) {
        insertIndex(value,score,0);
    }
    //在为末尾插入
    public void insert(int value,int score) {
        insertIndex(value, score,len);
    }

    public void insertIndex(int value,int score,int index) {
        //头节点 index 为 1
        Node node = new Node(value,score);

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

    public Node getIndex(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node= node.next;
        }
        return node;
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        String line = scanner.nextLine();
        String arr[]  = line.split(" ");

        for (int i = 0; i <arr.length ; i++) {
            String tmp[] = arr[i].split(",");
            list.insert(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
        }



       for (int i = 0; i < 3; i++) {
            System.out.println(list.getIndex(i));
        }


    }

}
