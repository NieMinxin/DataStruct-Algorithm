package leetcode;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

public class Source {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList(); //已读
        LinkedList list = new LinkedList();//已读

        int array[][] = new int[1][2];

    }

    @Test
    public void fun() {
        int a=10;
        int b =20;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println(a);
        System.out.println(b);
    }
}
