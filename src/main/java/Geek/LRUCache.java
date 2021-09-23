package Geek;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(){

        }

        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private Map<Integer,Node> cache = new HashMap<>();

    private  int size;//大小

    private int capacity;//容量

    private  Node head,tail;//一个头节点，一个尾节点

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public String toString() {
        return "LRUCache{" +
                "cache=" + cache +
                '}';
    }

    public  int get(int key){
        Node node = cache.get(key);
        if(node==null){
            return -1;//没有这个节点
        }
        moveToHead(node);
        return node.value;
    }



    public void put(int key,int value){
        Node node = cache.get(key);
        if(node==null){
            Node newNode = new Node(key,value);
            cache.put(key,newNode);//添加到链表的头部
            addToHead(newNode);
            ++size;
            if(size>capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                Node tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }else {
            //如果存在，覆盖旧的value
            node.value = value;
            moveToHead(node);//使用过后放到头节点
        }

    }



    //使用过就将这个节点移动到头部，每次删除尾节点
    private void moveToHead(Node node){
        removeNode(node);//删掉这个节点后
        addToHead(node);//放置到头节点，借助链表的快速插入和删除
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private Node  removeTail(){
        Node cur = tail.prev;
        removeNode(cur);
        return cur;
    }


    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

}
