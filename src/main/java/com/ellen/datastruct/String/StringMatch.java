package com.ellen.datastruct.String;

public class StringMatch {

    public int indexOfBf(String src,String match){
        return indexOfBf(src,match,0);
    }
    public int indexOfBf(String src,String match,int start){
        int srcLen = src.length();
        int matchLen = match.length();
        int i = start,j=0;
        while (i<srcLen && j<matchLen){
            if(src.charAt(i)==match.charAt(j)){
                i++;
                j++;
            }else {
                i = i-j+1;
                j=0;//模式串从头开始
            }
        }
        if(j>=matchLen){
            return i-matchLen;
        }else {
            return -1;
        }
    }

    public  int[] getNext(String match){
        int len = match.length();
        int next[] = new int[len];
        next[0] = -1;
        int j = 1;
        int k = 0;
        while (j<len-1){
            if(match.charAt(j)==match.charAt(k)){
                next[j+1] = k+1;
                j++;
                k++;
            }else if(k==0){
                next[j+1] = 0;
                j++;
            }else {
                k = next[k];
            }
        }
        return next;
    }

    public  int indexOfKmp(String str,String match){
        int i = 0;
        int j = 0;
        int sLen = str.length();
        int mLen = match.length();
        int next[] = getNext(match);
        while (i<sLen && j<mLen){
            if(j==-1 || str.charAt(i)==match.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j==mLen){
            return i-j;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        StringMatch sm = new StringMatch();
        System.out.println(sm.indexOfKmp("hello,world","wodrld"));

    }


}
