package com.Github.IkhideIfidon;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Edge edge = new Edge(1, 2, 0.567);
        System.out.println(edge);
        final String file = "src/main/resources/tinyEWG.txt";
        try ( FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader) )

        {   EdgeWeightedGraph edgeWeightedGraph = new EdgeWeightedGraph(reader);
            System.out.println(edgeWeightedGraph.V());
            System.out.println(edgeWeightedGraph.E());
        }

        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}