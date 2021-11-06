package com.ellen.datastruct.Sorter;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        int  array[]  = new int[]{1,0,1,0,1,0,1,0,1,0};
        sorter.swapWb(array);
        System.out.println(Arrays.toString(array));
    }
}
