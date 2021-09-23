package com.ellen.datastruct.List;

import java.util.ArrayList;

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
        Integer i;

        java.util.LinkedList list;

        ArrayList dd;

        int a[] = new int[10];
        System.out.println(a.length);


    }

}
