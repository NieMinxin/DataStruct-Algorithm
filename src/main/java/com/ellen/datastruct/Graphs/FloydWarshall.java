package com.ellen.datastruct.Graphs;

public class FloydWarshall {
    private int DistanceMatrix[][];
    private int numberOfVertices; // number of vertices in the graph
    public static final int INFINITY = Integer.MAX_VALUE;

    public FloydWarshall(int numberOfVertices) {
        DistanceMatrix =
                new int[numberOfVertices + 1]
                        [numberOfVertices + 1]; // stores the value of distance from all the possible path form the source
        this.numberOfVertices = numberOfVertices;
    }

    public void  floydWarshall(int graph[][]){
        for (int source = 1; source <= numberOfVertices; source++) {
            for (int destination = 1; destination <= numberOfVertices; destination++) {
                DistanceMatrix[source][destination] = graph[source][destination];
            }
        }

        for (int intermediate = 1; intermediate <= numberOfVertices; intermediate++) {
            for (int source = 1; source <= numberOfVertices; source++) {
                for (int destination = 1; destination <= numberOfVertices; destination++) {
                    // 松弛操作
                    if (DistanceMatrix[source][intermediate] + DistanceMatrix[intermediate][destination]
                            < DistanceMatrix[source][destination])
                    {
                        DistanceMatrix[source][destination] =
                                DistanceMatrix[source][intermediate] + DistanceMatrix[intermediate][destination];
                    }
                }
            }
        }


        System.out.printf("floyd: \n");
        for (int i = 1; i <= numberOfVertices; i++) {
            for (int j = 0; j < numberOfVertices; j++)
                System.out.printf("%2d  ", graph[i][j]);
            System.out.printf("\n");
        }

    }

    public static void main(String[] args) {
        int MAX = INFINITY;
        int[][] weight = {
                {0, 1, 12, MAX, MAX, MAX},
                {MAX, 0, 9, 3, MAX, MAX},
                {MAX, MAX, 0, MAX, 5, MAX},
                {MAX, MAX, 4, 0, 13, 15},
                {MAX, MAX, MAX, MAX, 0, 4},
                {MAX, MAX, MAX, MAX, MAX, 0}
        };

        FloydWarshall flody = new FloydWarshall(5);
        flody.floydWarshall(weight);


    }




}
