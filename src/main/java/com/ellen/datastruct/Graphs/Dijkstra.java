package com.ellen.datastruct.Graphs;

import java.util.Arrays;

public class Dijkstra {

    public static void main(String[] args) {
        int MAX = Integer.MAX_VALUE;    // 无法到达时距离设为 Integer.MAX_VALUE
        int[][] weight = {
                {0, 1, 12, MAX, MAX, MAX},
                {MAX, 0, 9, 3, MAX, MAX},
                {MAX, MAX, 0, MAX, 5, MAX},
                {MAX, MAX, 4, 0, 13, 15},
                {MAX, MAX, MAX, MAX, 0, 4},
                {MAX, MAX, MAX, MAX, MAX, 0}
        };
        int start = 0;  // 选择出发点
        Dijkstra path = new Dijkstra();
        System.out.println(Arrays.toString(path.dijkstra(weight, start)));



    }

    //找到 最短邻边 的顶点的index
    private int minKey(int res[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < res.length; i++) {
            if (mstSet[i] == false && res[i] < min) {
                min = res[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public int[] dijkstra(int graph[][], int start) {
        boolean[] visit = new boolean[graph.length]; // 标记某节点是否被访问过
        visit[start] = true;
        int res[] = new int[graph.length];//记录start 点到各顶点的最短路径

        for (int i = 0; i < res.length; i++) {
            res[i] = graph[start][i];
        }
        //找其他的顶点
        for (int i = 1; i < graph.length; i++) {

            int index = minKey(res,visit);

            visit[index] = true;//访问后

            for (int j = 0; j < graph.length; j++) {
                //找到 index 的邻边
                if(j== index || graph[index][j]==Integer.MAX_VALUE){
                    continue;
                }
                if(res[index] + graph[index][j] < res[j]){
                    res[j] = res[index]+ graph[index][j];
                }
            }
        }

        return res;
    }



    public void floyd(int graph[][]) {
        for (int k = 0; k < graph.length; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // 打印
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                System.out.println(i + " " + j + ":" + graph[i][j]);
            }
        }
    }


}
