package com.ellen.datastruct.Hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.zip.ZipEntry;

public class Hash {
    private int size;

    private LinkedList buckets[];

    private int hashCode(int key){
        int hash = key % size;
        if(hash<0) hash+=size;
        return hash;
    }

    Hash(int size){
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList();
        }
        size=size;

    }

    public void insert(int key) {

        int index = hashCode(key);
        buckets[index].add(key);
        size++;
    }

    public  void delete(int key){
        int index = hashCode(key);
        buckets[index].remove(key);
        size--;
    }

    public int getSize() {
        return size;
    }

}
