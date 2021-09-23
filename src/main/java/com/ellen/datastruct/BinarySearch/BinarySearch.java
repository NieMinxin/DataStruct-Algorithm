package com.ellen.datastruct.BinarySearch;

public class BinarySearch {

    public static int binarySearch(int [] array,int value){
        int low = 0;
        int high = array.length-1;
        int middle = (low+high) >> 1;

        while (low<=high){
            if(array[middle]==value){
                return middle;
            }else if(array[middle]>value){
                high = middle-1;
            }else {
                low=middle+1;
            }
        }
        return -1;
    }

}
