package com.ellen.datastruct.Graphs;

public class MatrixGraph {

    private int vertex_num;
    private int edge_num;

    private int adjacency[][];

    static final int EDGE_EXIST = 1;
    static final int EDGE_NONE = 0;

    MatrixGraph(int vertex_num){
        this.vertex_num = vertex_num;
        adjacency = new int[vertex_num][vertex_num];
        edge_num = 0;
        for (int i = 0; i < vertex_num; i++) {
            for (int j = 0; j < vertex_num; j++) {
                adjacency[i][j] = EDGE_NONE;
            }
        }
        //初始化
    }

    //判断两条边是否存在
    private  boolean isExistOfEdge(int from,int to){
        return adjacency[from][to] == EDGE_EXIST;
    }


    //判断顶点是否存在
    public boolean vertexIsExist(int aVertex) {
        if (aVertex >= 0 && aVertex < this.vertex_num) {
            return true;
        } else {
            return false;
        }
    }

    public  boolean addEdge(int from,int to){
        //存在顶点添加边
        if(vertexIsExist(from) && vertexIsExist(to)){
            //如果不存在边，就添加
            if(!isExistOfEdge(from,to)){
                //无向图
                adjacency[from][to] = EDGE_EXIST;
                adjacency[to][from] = EDGE_EXIST;
                edge_num++;
                return true;
            }
        }
        return false;
    }

    public boolean removeEdge(int from,int to){
        if(vertexIsExist(from) && vertexIsExist(to)){
            if(isExistOfEdge(from,to)){
                adjacency[from][to] = EDGE_NONE;
                adjacency[to][from] = EDGE_NONE;
                edge_num--;
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < vertex_num; i++) {
            sb.append("[");
            for (int j = 0; j <vertex_num ; j++) {
                sb.append(adjacency[i][j]);
                sb.append("\t");
            }
            sb.append("]");
            sb.append("\n");

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(5);
        graph.addEdge(0,2);
        graph.addEdge(3,1);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(0,3);

        System.out.println(graph);

    }


}
