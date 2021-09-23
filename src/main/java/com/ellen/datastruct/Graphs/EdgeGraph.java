package com.ellen.datastruct.Graphs;

import java.util.ArrayList;

public class EdgeGraph {
    public int v;//顶点的个数
    public int e; //边的个数

    public ArrayList<Edge>[] adj; //邻接表

    //内部类
    class Edge{
        private int v; //边的起点
        private int w; //边的终点


        public Edge(int v,int w){
            this.v=v;
            this.w=w;

        }

        public int from(){
            return v;
        }

        public int to(){
            return w;
        }



        @Override
        public String toString() {
            return String.format("%d->%d",v,w);
        }
    }

    EdgeGraph(int v){
        this.v=v;
        this.e=e;
        adj=new ArrayList[v];
        for(int i=0;i<v;i++){
            adj[i]=new ArrayList<Edge>();
        }

    }


    public void addEdge(Edge e){
        adj[e.from()].add(e);
        this.e++;
    }

    public void printEdge(){
        for(int i=0;i<v;i++){
            for(Edge e:adj[i]){
                System.out.println(e+" ");
            }
        }
    }



}
