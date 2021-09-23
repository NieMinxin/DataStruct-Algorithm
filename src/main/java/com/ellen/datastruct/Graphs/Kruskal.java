package com.ellen.datastruct.Graphs;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Kruskal {

    /*
        edge 作为 边
        from 弧头
        to 弧位
        weight 权值
    * */
    private    class Edge{
        private int from;
        private  int to;
        private int weight;
        Edge(int from,int to,int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }




    }


    private int V;//顶点数量
    private  int E;//边的数量

    //hashset 确保邻节点的元素唯一
    private  HashSet<Edge>  adj[];//邻节点


    //构造器 ，初始化 。顶点数 为 V
    Kruskal(int v){
        adj = new HashSet[v];
        for(int i=0;i<v;i++){
            adj[i]=new HashSet<>();
        }
        this.V = v;
    }


    public  HashSet<Edge>[] getAdj() {
        return adj;
    }

    @Override
    public String toString() {

        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < adj.length; i++) {
            for (Edge e:adj[i]
                 ) {
                sb.append(String.format("%d -- weight : %d ----> %d\n", i,e.weight,e.to));
            }
        }

        return sb.toString();
    }

    public  String print(HashSet<Edge> miniGraph[]){
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < miniGraph.length; i++) {
            for (Edge e:miniGraph[i]
            ) {
                sb.append(String.format("%d -- weight : %d ----> %d\n", i,e.weight,e.to));
            }
        }

        return sb.toString();
    }

    //添加边
    public  void addEdge(int from,int to,int weight){
        if(adj!=null){
            adj[from].add(new Edge(from,to,weight));
        }

    }

    public  void addEdge(HashSet<Edge> graph[],int from,int to,int weight){
        if(graph!=null){
            graph[from].add(new Edge(from,to,weight));
        }

    }

    //kruskal

    public HashSet<Edge>[] kruskal(){
        int vertexes = V;

        int captain[] = new int[vertexes]; //
        // captain of i, stores the set with all the connected nodes to i

        HashSet<Integer> connectedGroups[] = new HashSet[vertexes];

        HashSet<Edge>[] minGraph = new HashSet[vertexes];//最小生成树
        PriorityQueue<Edge> edges = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));//堆,获取每一个最小的边

        //初始化
        for (int i = 0; i < vertexes; i++) {
            minGraph[i] = new HashSet<>();//
            connectedGroups[i] = new HashSet<>();
            connectedGroups[i].add(i);//把图中的n个顶点看成独立的n棵树组成的森林
            captain[i] = i;
            edges.addAll(adj[i]);//堆排序
        }

        int connectedElements = 0;

        while (connectedElements!=vertexes && !edges.isEmpty()){
            Edge edge  = edges.poll();//取出最小的 edge
            // This if avoids cycles
            if(!connectedGroups[captain[edge.from]].contains(edge.to) &&
                    !connectedGroups[captain[edge.to]].contains(edge.from)
                    //if 防止一条边添加两次
            ){
                //merge sets of the captains of each point connected by the edge
                connectedGroups[captain[edge.from]].addAll(connectedGroups[captain[edge.to]]);
                connectedGroups[captain[edge.from]].forEach(i->{ captain[i] = captain[edge.from];});
                addEdge(minGraph,edge.from,edge.to,edge.weight);
                connectedElements = connectedGroups[captain[edge.from]].size();
            }
        }
        return minGraph;
    }



    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal(5);

        kruskal.addEdge(0,1,1);
        kruskal.addEdge(0,2,10);
        kruskal.addEdge(1,2,2);
        kruskal.addEdge(1,4,9);
        kruskal.addEdge(2,4,4);
        kruskal.addEdge(0,3,7);

        System.out.println(kruskal.toString());

        System.out.println(kruskal.print(kruskal.kruskal()));;




    }




}
