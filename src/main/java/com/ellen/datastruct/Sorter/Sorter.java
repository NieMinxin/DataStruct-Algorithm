package com.ellen.datastruct.Sorter;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Sorter {

    public int[] insertionSort(int array[]) {
        //从第二个元素开始 ，如果比前面的元素大，则交换，进行n-1 躺
        for (int i = 1; i <array.length ; i++) {
            if(array[i] < array[i-1]){
                int tmp = array[i];//记录当前元素的值
                int j;
                //这个循环将 tmp 元素保存的当前元素的值 和前面每一个元素比，如果小于就把这个元素往移动一位，然后在前面插入
                for (j = i-1; j >=0 && tmp < array[j]; j--) {
                    array[j+1] = array[j];//tmp = array[i]，把这个数和前面的数比，大于的数往后面移动
                }
                array[j+1] = tmp;//比前面的数小，那么放到j+1，插入
            }
        }
        return array;
    }


    //冒泡排序的思想是
    public  int [] bubbleSort(int array[]){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    int tmp= array[j];
                    array[j+1] = array[j];
                    array[j]=tmp;
                }
            }
        }
        return array;
    }

    public int [] SelectionSort(int array[]){
        for (int i = 0; i <array.length ; i++) {
            int index = i;//记录最小元素的index
            for (int j = i+1; j < array.length; j++) {
                if (array[index]>array[j]){
                    index = j;
                }
            }
            //如果 index = i不需要做交换
            if(i!=index){
                int tmp;
                tmp = array[i];
                array[i]=array[index];
                array[index] = tmp;
            }
        }
        return  array;
    }


    //快速排序
    public int[] quickSort(int [] array,int left,int right) {
        if(left<right){
            int pivot = array[left];
            int low = left;//
            int high = right;
            while (low<high){

                while (low<high && array[high]>=pivot){
                    //找到小于pivot的数
                    high--;
                }
                array[low] = array[high];//将小的数填到 index

                while (low<high && array[low]<pivot){
                    //array[low] 坑上必定为 小于基准的值 ，low ++
                    low++;//找到 小于 pivot 的值停止  找到大于pivot的数
                }
                array[high] = array[low];
            }
            array[low] = pivot;
            quickSort(array, left, low - 1);//递归调用
            quickSort(array, low + 1, right);
        }

        return  array;
    }


    public int []  shellSort(int[] array) {
        int n = array.length;
        int h;
        for (h = n / 2; h > 0; h /= 2) {
            for (int i = h; i < n; i++) {
                for (int j = i - h; j >= 0; j -= h) {
                    if (array[j] > array[j + h]) {
                        int temp = array[j];
                        array[j] = array[j + h];
                        array[j + h] = temp;
                    }
                }
            }
        }
        return array;
    }

    //堆排序
    public int[] heapSort(int [] array) {
        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < array.length; i++) {
            queue.offer(array[i]);
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) queue.poll();
        }
        return array;
    }




   /* public  void merge(int[] arrays, int L, int M, int R) {
        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;
        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            // 等于的情况是保证“稳定”
            if (leftArray[i] <= rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }*/


    public int [] mergeSort(int [] array,int left,int right){
        //如果只有一个元素，那就不用排序了
        if(left==right){
            return array;
        }else {
            //取中间的数，进行拆分
            int middle = (left+ right)/2;
            //左边继续排序
            mergeSort(array,left,middle);
            //右边继续排序
            mergeSort(array,middle+1,right);

            merge(array,left,middle+1,right);
        }
        return array;
    }


    public  void merge(int[] arrays, int L, int M, int R) {
        //左边的数组的大小
        int[] leftArray = new int[M - L];

        //右边的数组大小
        int[] rightArray = new int[R - M + 1];

        //往这两个数组填充数据
        for (int i = L; i < M; i++) {
            leftArray[i - L] = arrays[i];
        }
        for (int i = M; i <= R; i++) {
            rightArray[i - M] = arrays[i];
        }
        int i = 0, j = 0;
        // arrays数组的第一个元素
        int  k = L;
        //比较这两个数组的值，哪个小，就往数组上放
        while (i < leftArray.length && j < rightArray.length) {
            //谁比较小，谁将元素放入大数组中,移动指针，继续比较下一个
            // 等于的情况是保证“稳定”
            if (leftArray[i] <= rightArray[j]) {
                arrays[k] = leftArray[i];
                i++;
                k++;
            } else {
                arrays[k] = rightArray[j];
                j++;
                k++;
            }
        }
        //如果左边的数组还没比较完，右边的数都已经完了，那么将左边的数抄到大数组中(剩下的都是大数字)
        while (i < leftArray.length) {
            arrays[k] = leftArray[i];
            i++;
            k++;
        }
        //如果右边的数组还没比较完，左边的数都已经完了，那么将右边的数抄到大数组中(剩下的都是大数字)
        while (j < rightArray.length) {
            arrays[k] = rightArray[j];
            k++;
            j++;
        }
    }




    public static void main(String[] args) {
        int array[] = new int[]{3,44,38,5,15,27,36,2,5,19,58,10};
        Sorter sorter = new Sorter();
        /*System.out.println(Arrays.toString(sorter.insertionSort(array)));//插入排序
        System.out.println(Arrays.toString(sorter.bubbleSort(array)));//冒泡排序
        System.out.println(Arrays.toString(sorter.SelectionSort(array)));//选择排序
        System.out.println(Arrays.toString(sorter.shellSort(array)));//shell排序*/

        sorter.mergeSort(array,0, array.length-1);
        System.out.println(Arrays.toString(sorter.mergeSort(array,0, array.length-1)));//归并排序

        int array1[] = new int[]{3,44,38,5,15,27,36,2,5,19,58,10};

        System.out.println(Arrays.toString(sorter.quickSort(array,0, array.length-1)));//快速排序


    }


}
