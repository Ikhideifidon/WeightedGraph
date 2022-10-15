package com.Github.IkhideIfidon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[][] edges =
                {
                        {4, 5}, {4, 7}, {5, 7}, {0, 7}, {1, 5}, {0, 4}, {2, 3}, {1, 7}, {0, 2},
                        {1, 2}, {1, 3}, {2, 7}, {6, 2}, {3, 6}, {6, 0}, {6, 4}
                };
        double[] weight = {0.35, 0.37, 0.28, 0.16, 0.32, 0.38, 0.17, 0.19, 0.26, 0.36, 0.29,
        0.34, 0.40, 0.52, 0.58, 0.93};

        EdgeWeightedGraph weightedGraph = new EdgeWeightedGraph(8);
        int i = 0;
        for (int[] edge : edges) {
            Edge e = new Edge(edge[0], edge[1], weight[i++]);
            weightedGraph.addEdge(e);
        }

        System.out.println(weightedGraph);



        System.out.println("\nFrom File");
        final String file = "src/main/resources/tinyEWG.txt";
        try ( FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader) )
        {
            EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(reader);
            System.out.println(edgeWeightedGraph);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        LazyPrimMST prim = new LazyPrimMST(weightedGraph);
        System.out.println(prim.edges());
        System.out.println(prim.weight());

        System.out.println(weightedGraph.neighbor(0));


    }
}