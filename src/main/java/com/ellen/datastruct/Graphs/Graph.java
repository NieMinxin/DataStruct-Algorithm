package com.ellen.datastruct.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Graph<E extends Comparable<E>> {

    class Node<E> {
        E name;
        public Node(E name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "name=" + name +
                    '}';
        }
    }

    class  Edge<E>{
        Node start,end;
        public Edge(Node<E> start,Node<E> end){
            this.start=start;
            this.end = end;
        }
    }

    Graph(){
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
        parents = new ArrayList<>();
    }

    private ArrayList<Node<E>> nodes;
    private ArrayList<Edge<E>> edges;

    public void addEdge(E startNode,E endNode){
        Node start = null, end = null;
        for (Node<E> node : nodes) {
            if (startNode.compareTo(node.name) == 0) {
                start = node;
            } else if (endNode.compareTo(node.name) == 0) {
                end = node;
            }
        }
        if (start == null) {
            start = new Node(startNode);
            nodes.add(start);
        }
        if (end == null) {
            end = new Node(endNode);
            nodes.add(end);
        }

        edges.add(new Edge(start, end));
    }


    public ArrayList<Node<E>>  dfs(Node<E> first,ArrayList<Node<E>> visited){
        visited.add(first);
        for (Edge<E> edge:edges
        ) {
            if (edge.start.equals(first) && !visited.contains(edge.end)){
                dfs(edge.end,visited);
            }
        }
        return visited;
    }

    private ArrayList<Node<E>> parents;

    private void  dfsGetParent(Node<E> first,Node<E> parent,ArrayList<Node<E>> visited){
        visited.add(first);
        parents.add(parent);
        for (Edge<E> edge:edges
        ) {
            if (edge.start.equals(first) && !visited.contains(edge.end)){
                dfsGetParent(edge.end,first,visited);
            }
        }

    }



    public  int countGraphs(){
        int count =0;
        Set<Node<E>> set = new HashSet<>();

        for (Node<E> node:nodes
             ) {
            if(!set.contains(node)){
                set.add(node);
                set.addAll(dfs(node,new ArrayList<>()));//深度优先搜索,会搜索到一个连通图的所有节点，放入set中
                count++;
            }
        }
        return count;
    }





    public Iterable<Node<E>> getPath(E start,E end, ArrayList<Node<E>> path){


        Node startN=null,endN=null;
        for (Node<E> n:nodes
             ) {
            if(end.compareTo(n.name)==0){
                endN = n;
            }else if(start.compareTo(n.name)==0){
                startN = n;
            }
        }
        if(startN==null){
            throw new IllegalArgumentException("error");
        }

        dfsGetParent(startN,startN,new ArrayList<>());

        Node<E> t = endN;
        while (t!=startN){
            path.add(t);
            t = parents.get(nodes.indexOf(t));
        }
        //添加源 start节点
        path.add(startN);
        return path;
    }


    public boolean isConnected(ArrayList<Node<E>> visited,Node<E> node){

        return visited.contains(node);
    }

    public static void main(String[] args) {
        Graph<Character> graphChars = new Graph<>();

        // Graph 1
        graphChars.addEdge('a', 'b');
        graphChars.addEdge('a', 'e');
        graphChars.addEdge('b', 'e');
        graphChars.addEdge('b', 'c');
        graphChars.addEdge('c', 'd');
        graphChars.addEdge('d', 'a');



        Graph<Integer> graphInts = new Graph<>();
        ArrayList dfs = new ArrayList();
        dfs = graphChars.dfs(graphChars.nodes.get(0),dfs);
        System.out.println(dfs);

        ArrayList p = new ArrayList();

        graphChars.getPath('a','d',p);
        System.out.println(p);

        // Graph 2
        graphInts.addEdge(1, 2);
        graphInts.addEdge(2, 3);
        graphInts.addEdge(2, 4);
        graphInts.addEdge(3, 5);

        graphInts.addEdge(7, 8);
        graphInts.addEdge(8, 10);
        graphInts.addEdge(10, 8);

        System.out.println("Amount of different char-graphs: " + graphChars.countGraphs());
        System.out.println("Amount of different int-graphs: " + graphInts.countGraphs());
    }

}
