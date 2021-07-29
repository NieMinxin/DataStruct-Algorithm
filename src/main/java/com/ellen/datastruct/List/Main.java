package com.ellen.datastruct.List;

class Main{
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        linkedList.insertHead(10);
        linkedList.insertIndex(20,1);
        linkedList.insert(30);
        linkedList.insert(40);
        linkedList.insertIndex(50,2);
        linkedList.insertIndex(60,1);

        System.out.println(linkedList.getLen());
        System.out.println(linkedList.print());
        //ArrayLIst 源码阅读

        java.util.LinkedList list;




    }

}
