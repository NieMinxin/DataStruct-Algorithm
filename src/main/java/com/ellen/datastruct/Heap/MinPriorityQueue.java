package com.ellen.datastruct.Heap;

public class MinPriorityQueue {

    private  int heap[];//数组实现
    //**对于任意的i节点，其左儿子的索引为2i，右儿子的索引为2i+1,它的父亲索引则为i/2。
    // 因此，不要链式存储结构，而且遍历操作十分简单。**
    private  int capacity;
    private  int size;

    MinPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1];
    }


    //返回堆顶
    public  int peek(){
        return heap[1];
    }

    //
    public boolean isEmpty(){
        if(0==this.size){
            return true;
        }else
            return false;
    }


    public boolean isFull(){
        return this.size==capacity;
    }

    public int getSize() {
        return size;
    }



    public void print(){
        for (int i = 1; i < capacity; i++) {
            System.out.println(String.format("heap[%d]: %d", i,heap[i]));
        }

    }


    //**对于任意的i节点，其左儿子的索引为2i，右儿子的索引为2i+1,它的父亲索引则为i/2。
    // 因此，不要链式存储结构，而且遍历操作十分简单。**
    public void insert(int value){
        if(isFull()){
            return;
        }

        heap[size+1] = value;

        int key = size+1;
        //上滤
        while (key>1){
            if(heap[key] < heap[key/2]){
                int tmp = heap[key];
                heap[key] = heap[key/2];
                heap[key/2] = tmp;
            }
            key=key/2;
        }
        this.size++;
    }



    private void sink(){
        int k = 1;
        while (k*2< size || k*2+1 <size ){
            int minIndex;
            //两个子节点都大于父节点，
            if(heap[k*2]>=heap[k]){
                //左子节点大于父节点
                if (2 * k + 1 <= this.size && this.heap[2 * k + 1] >= this.heap[k]) {
                    break; //有没有右子节点  ，右子节点大于父节点
                } else if (2 * k + 1 > this.size) {
                    break;//超过元素的个数，直接跳出循环
                }
            }
            //只有左子节点
            if(2*k+1>size){
                minIndex = heap[k*2]<heap[k] ? k*2 : k;
            }else {
                //从两个子节点选择一个较小的元素
                if (this.heap[k] > this.heap[2 * k] || this.heap[k] > this.heap[2 * k + 1]) {
                    minIndex = this.heap[2 * k] < this.heap[2 * k + 1] ? 2 * k : 2 * k + 1;
                } else {
                    minIndex = k;
                }
            }

            int tmp =  heap[k];
            heap[k] = heap[minIndex];
            heap[minIndex] = tmp;
            k = minIndex;
        }

    }
    /*
    * **当删除一个元素的时候，要在根节点建立一个空穴。
    * 由于堆少了一个元素，因此堆中最后一个元素X必须移动到该堆的某个地方
    * 因此我们需要比较两个子元素的值来选择出新的父元素。这种操作叫做下滤***/

    public int delete(){
        int min = heap[1];
        //把堆顶元素删掉,最后一个元素X 和堆顶元素互换
        heap[1] = heap[size];
        heap[size] = min;

        this.size--;
        sink();//从堆顶元素开始下沉
        return min;
    }


    public static void main(String[] args) {
        MinPriorityQueue heap  = new MinPriorityQueue(10);
        heap.insert(10);
        heap.insert(20);
        heap.insert(11);
        heap.insert(7);
        heap.print();
    }


}
