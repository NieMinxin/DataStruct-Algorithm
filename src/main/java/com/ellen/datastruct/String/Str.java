package com.ellen.datastruct.String;

import java.util.Arrays;

public class Str {
    //不可变
    private final char value[];

    private  int hash;
    //hash
    public int hashCode() {
        int h = hash;
        if (h == 0 && value.length > 0) {
            char val[] = value;
            for (int i = 0; i < value.length; i++) {
                h = 31 * h + val[i];
            }
            hash = h;
        }
        return h;
    }

    public Str(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }


    public Str(char[] value, int beginIndex, int len) throws Exception {
        if(beginIndex<0){
            throw  new Exception("字符串索引必须从0开始");
        }
        if(len<0){
            throw  new Exception("字符串长度不能小于零");
        }
        if(beginIndex+len > value.length){
            throw  new Exception("字符串长度超过最大");
        }
        this.value =  Arrays.copyOfRange(value,beginIndex,len);
    }


    public boolean isEmpty() {
        return value.length == 0;
    }

    public int length() {
        return value.length;
    }

    //检查索引
    private void CheckIndexOfString(int index) {
        if (index < 0 || index >= this.value.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public char CharAt(int index) {
        CheckIndexOfString(index);
        return value[index];
    }


    //根据字符查找索引
    public int indexOf(char c) {
        for (int i = 0; i < value.length; i++) {
            if(value[i]==c){
                return  i;
            }
        }
        return -1;
    }

    //查找子串 ，naive 算法
    public int indexOf(Str s){
        return indexOf(value,0, value.length, s.value,0,s.value.length,0);
    }
    /*
    * @param   source   源字符串
    * @param     sourceOffset   从字符串的那个位置开始查找
    * @param   sCount  在字符串查找多少个字符
    * @param  target  子串
    * @param  targetOffset 从子串的那个位置开始找
    * @param  tCount  count of the target string
    * @param fromIndex  那个index 开始
    * @return  返回查找到 子串 在 源字符串的第一个字符的index ，否则 返回 -1
    * */
    private int indexOf(char [] source, int sourceOffset,int sCount, char [] target, int targetOffset, int tCount,int fromIndex
    ){
        //从 fromIndex 开始查找
        if(fromIndex >=sCount){
            throw  new ArrayIndexOutOfBoundsException();
        }
        if (fromIndex < 0) {
            fromIndex = 0;
        }
        if (tCount == 0) {
            return -1;
        }
        if(sourceOffset + sCount < targetOffset+tCount){
            return -1;
        }

        char first = target[targetOffset];//获取从选择的第一个字符开始
        int max = sourceOffset + sCount - tCount;//max 减少后面 的字符长度小于子串长度的 匹配开销

        for (int i = sourceOffset+fromIndex; i <=max; i++) {
            if(source[i] !=first){
                while (++i <= max && source[i] != first);//
            }
            
            //找到第一个匹配的字符
            if(i<=max){
                int j = i+1;
                int end = j+tCount -1;//和 子串相同大小的区间
                for (int k = targetOffset+1; k < end ; k++){
                    if(source[j]==target[k]){
                        j++;
                        k++;
                    }
                }
                //成功扎到这个子串
                if(j==end){
                    return i-sourceOffset;//starting at the specified index,
                }
            }
        }
        return -1;
    }




    public Str subString(int beginIndex) throws Exception {
        if(beginIndex<0){
            throw  new Exception("index不能小于零");
        }
        int subLen = value.length - beginIndex;
        if(subLen> value.length){
            throw new Exception("error");
        }
        return (beginIndex==0) ? this : new Str(value,beginIndex,subLen);

    }

    public Str subString(int beginIndex, int endIndex) throws Exception {
        if(beginIndex<0){
            throw  new Exception("index不能小于零");
        }
        if(endIndex > value.length){
            throw  new Exception("index Error");
        }

        int subLen = endIndex-beginIndex;

        return (beginIndex==0 && subLen== value.length) ? this : new Str(value,beginIndex,subLen);
    }


    //转换成数组

    public char[] toCharArray(){
        char [] tmp = new char[value.length];
        for (int i = 0; i < value.length; i++) {
            tmp[i] = value[i];
        }
        return tmp;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            sb.append(value[i]);
        }
        return sb.toString();
    }

    public void toUpper(){
        for (int i = 0; i < value.length; i++) {
            value[i] = (char) (value[i]-32);
        }
    }

    public void toLower(){
        for (int i = 0; i < value.length; i++) {
            value[i] = (char) (value[i]+32);
        }
    }


    //replace
    public char replace(int index, char c){
        char tmp = value[index];
       value[index] = c;
       return tmp;
    }

    public void replaceALL(char oldValue,char newValue){

        for (int i = 0; i <value.length ; i++) {
            if(value[i]==oldValue){
                value[i]= newValue;
            }
        }

    }

    private int[] getNext(String str){
        int len = str.length();
        int next[] = new int[len];
        next[0] = -1;
        next[1] = 0;
        int k = 0;
        int j = 1;
        while (j<len-1){
            if(str.charAt(j)==str.charAt(k)){
                next[j+1] = k + 1;
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

    public  boolean contain(char c){
        return indexOf(c)==-1;
    }


    public int indexOfKmp(String src,String tar){
        int i = 0;
        int j = 0;
        int sLen = src.length();
        int tLen = tar.length();
        int next[] = getNext(tar);
        while (i < sLen && j < tLen)
        {
            //①如果j = -1，或者当前字符匹配成功（即S[i] == P[j]），都令i++，j++
            if (j == -1 || src.charAt(i) == tar.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                //②如果j != -1，且当前字符匹配失败（即S[i] != P[j]），则令 i 不变，j = next[j]
                //next[j]即为j所对应的next值
                j = next[j];
            }
        }
        if (j == tLen)
            return i - j;
        else
            return -1;
    }



    public int indexOfBf(String src,String sub,int start){
        int srcL = src.length();
        int subL = sub.length();
        int i = start,j=0;
        while (i<srcL && j<subL){
            if(src.charAt(i)==sub.charAt(j)){
                i++;j++;
            }
            else {
                i= i-j+1;
                j=0;
            }
        }
        if(j>=subL){
            return i-subL;
        }else {
            return -1;
        }
    }




    public static void main(String[] args) throws Exception {
        String s = "";

    }


}
