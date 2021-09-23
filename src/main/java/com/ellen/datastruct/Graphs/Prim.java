package com.ellen.datastruct.Graphs;

public class Prim {

    private static  final  int V=5;

    //找到 权值数组中 某一权值的 索引，也就是该节点 ，通过 这个顶点访问 其他的边
    private  int minKey(int key[],Boolean mstSet[]){
        int min = Integer.MAX_VALUE ,min_index =-1;
        for (int i = 0; i <V ; i++) {
            if(mstSet[i] == false && key[i]<min){
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }


    private void printMST(int parent[],int n,int graph[][]){
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
    }


    public  void  PrimMst(int graph[][]){
        int parent [] = new int[V];//存储 最小生成树
        int key[]  = new int[V];//存储权值

        Boolean mstSet[] = new Boolean[V];// 存储顶点是否访问过

        //初始化
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }


        key[0] = 0;//第一个节点 切分

        parent[0] = -1;// First node is always root of MST

        //至多 这一个节点连接 V-1 个节点
        for (int i = 0; i <V-1 ; i++) {
            int u = minKey(key,mstSet);//第一次返回  第一个节点 也就是 0 节点

            mstSet[u] = true;

            //将每个节点的 边 全部添加 到 key 中 ，后面的节点继续比较 ，如果比上次 添加的结果 小 则 继续 放回到 key 中 ，并且 parent 的值也要更新
            //每次访问过一个节点 ，将节点 放入 布尔数组中，表示该数已经访问过
            for (int v = 0; v < V; v++){
                if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;//记录前面一个节点
                    key[v] = graph[u][v];//获取最小的权值
                }
            }

        }
        printMST(parent,V,graph);
    }

    public static void main(String[] args) {
        Prim t = new Prim();
        int graph[][] =
                new int[][] {
                        {0, 2, 0, 6, 0}, {2, 0, 3, 8, 5}, {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0},
                };

        // Print the solution
        t.PrimMst(graph);
    }

}
