package com.ellen.datastruct.Graphs;

import org.junit.Test;

import java.util.*;

public class Graphs<E extends Comparable<E>> {


    private ArrayList<Vertex<E>> result_dfs = new ArrayList();
    private ArrayList<Vertex<E>> result_bfs = new ArrayList();

    Queue<Vertex<E>> queue = new ArrayDeque<>();

    private ArrayList<Vertex<E>> vertexes;
    private  boolean visited[];
    public Graphs() {
        vertexes = new ArrayList<>();
    }



    private static class Vertex<E extends Comparable<E>> {
        E data;
        int dist;
        Vertex path;
        int indgree;
        boolean know;
        ArrayList<Vertex<E>> adjacentVerticies;

        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            indgree =0;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Vertex{" +
                    "data=" + data +
                    '}';
        }

        public boolean addAdjacentVertex(Vertex to) {
            for (Vertex v : adjacentVerticies) {
                if (v.data.compareTo(to.data) == 0) {
                    return false; // the edge already exists
                }
            }
            to.indgree++;
            return adjacentVerticies.add(to); // this will return true;
        }

        public boolean removeAdjacentVertex(E to) {
            // use indexes here so it is possible to
            // remove easily without implementing
            // equals method that ArrayList.remove(Object o) uses
            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(to) == 0) {
                    adjacentVerticies.get(i).indgree--;
                    adjacentVerticies.remove(i);

                    return true;
                }
            }
            return false;
        }
    }

    /**
     * this method removes an edge from the graph between two specified verticies
     *
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns false if the edge doesn't exist, returns true if the edge exists and is removed
     */
    public boolean removeEdge(E from, E to) {
        Vertex fromV = null;
        for (Vertex<E> v : vertexes) {
            if (from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if (fromV == null) return false;
        return fromV.removeAdjacentVertex(to);
    }

    /**
     * this method adds an edge to the graph between two specified verticies
     *
     * @param from the data of the vertex the edge is from
     * @param to the data of the vertex the edge is going to
     * @return returns true if the edge did not exist, return false if it already did
     */
    public boolean addEdge(E from, E to) {
        Vertex fromV = null, toV = null;
        for (Vertex<E> v : vertexes) {
            if (from.compareTo(v.data) == 0) { // see if from vertex already exists
                fromV = v;
            } else if (to.compareTo(v.data) == 0) { // see if to vertex already exists
                toV = v;
            }
            if (fromV != null && toV != null) break; // both nodes exist so stop searching
        }
        if (fromV == null) {
            fromV = new Vertex(from);
            vertexes.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            vertexes.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Vertex<E> v:vertexes
             ) {
            sb.append("vertex:");
            sb.append(v.data);
            sb.append("\t\t");
            sb.append("adjacent:");

            for (Vertex<E> vertex : v.adjacentVerticies) {
                sb.append(vertex.data);
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    private void   UnWeightedPath(Vertex source){
        ArrayList<Vertex> vertexes  = new ArrayList<>();
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        //initial
        for (Vertex v: getVertexes()
             ) {
            v.dist = Integer.MAX_VALUE;
            v.know = false;
        }
        source.dist = 0;
        queue.offer(source);
        source.know=true;

        while (!queue.isEmpty()){
            Vertex<E> tmp = queue.poll();

            for (Vertex<E> adj: tmp.adjacentVerticies
                 ) {
                if(!adj.know && adj.dist==Integer.MAX_VALUE){

                    adj.dist = tmp.dist+1;
                    adj.path = tmp;
                    queue.offer(adj);
                    adj.know=true;
                }
            }
        }

    }


    public void printUnweightedPath(Vertex<E> s){
        UnWeightedPath(s);
        for (Vertex<E> v:getVertexes()
             ) {
            System.out.println(String.format("path: %d\t", v.dist));
        }

    }

    public void dfs(Vertex<E> vertex,boolean[] visited){
        visited[vertexes.indexOf(vertex)] = true;
        result_dfs.add(vertex);
        Iterator<Vertex<E>> iterator = vertex.adjacentVerticies.iterator();
        while (iterator.hasNext()){
            Vertex<E> tmp = iterator.next();
            if(!visited[vertexes.indexOf(tmp)]){
                dfs(tmp,visited);
            }
        }

    }


    public void BFS(Vertex<E> vertex,boolean[] visited){
        queue.offer(vertex);//把根节点放入队列中
        visited[vertexes.indexOf(vertex)] = true;
        while (!queue.isEmpty()){
            Vertex<E> tmp = queue.poll();
            result_bfs.add(tmp);//出队
            for (Vertex<E> v : tmp.adjacentVerticies
                    ) {
                if(!visited[getVertexes().indexOf(v)]){
                    //如果没访问过将这些邻节点全部入队
                    queue.offer(v);
                    visited[vertexes.indexOf(v)] = true;//已访问
                }
            }
        }
    }


    //拓扑排序
    public List<Vertex> topologicalSort(){
        List<Vertex> topoRes = new ArrayList<>();
        int len = vertexes.size();
        int [] degree = new int[len];
        for (int i = 0; i<len; i++) {
            degree[i]=vertexes.get(i).indgree;

        }

        //队列
        ArrayDeque<Vertex<E>> deque = new ArrayDeque();

        for (int i = 0; i < len; i++) {
            if(degree[i]==0)
                deque.offer(vertexes.get(0));
        }

        //广度优先搜索 实现拓扑排序
        while (!deque.isEmpty()){
            Vertex<E>  cur = deque.poll();
            topoRes.add(cur);

            for (Vertex<E> v:cur.adjacentVerticies
                 ) {
                v.indgree--;//入度全部减1
                if(v.indgree==0){
                    deque.offer(v);
                }
            }
        }

        return topoRes;
    }




    public ArrayList<Vertex<E>> getVertexes() {
        return vertexes;
    }

    public void printDFS(){
        for (Vertex<E> v:result_dfs
             ) {
            System.out.print("data:\t"+v.data);
            System.out.print("->");
        }
    }

    public void PrintBFS(){
        for (Vertex<E> v:result_bfs
        ) {
            System.out.print("data:"+v.data+"\t");
            System.out.print("->");
        }
        System.out.println();
    }

    public int getSize(){
        return vertexes.size();
    }

    public static void main(String[] args) {
        Graphs graph = new Graphs();
        graph.addEdge(3,5);
        graph.addEdge(3,6);
        graph.addEdge(6,7);
        graph.addEdge(6,5);
        graph.addEdge(3,7);
        graph.addEdge(5,4);
        graph.addEdge(7,4);


        System.out.println(graph);

        graph.dfs((Vertex) graph.getVertexes().get(0),new boolean[graph.getSize()]);

        graph.printDFS();
        System.out.println();
        System.out.println(graph.result_dfs.size());

        graph.BFS((Vertex) graph.getVertexes().get(0),new boolean[graph.getSize()]);
        graph.PrintBFS();


        graph.printUnweightedPath((Vertex) graph.getVertexes().get(0));


        System.out.println(graph.topologicalSort());


    }
}
