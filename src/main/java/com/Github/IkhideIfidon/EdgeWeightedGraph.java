package com.Github.IkhideIfidon;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class EdgeWeightedGraph {
    // Instance Variables
    private final int V;
    private int E;
    private final List<Edge>[] adjacent;

    // Constructor
    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        //noinspection unchecked
        adjacent = (List<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++)
            adjacent[v] = new LinkedList<>();
    }

    public EdgeWeightedGraph(BufferedReader in) throws IOException {
        this(Integer.parseInt(in.readLine()));
        this.E = Integer.parseInt(in.readLine());
        for (int i = 0; i < V; i++) {
            // Add an edge
            String[] stringSplit = in.readLine().split("[ \\t]+"); // capture one or more space and tab
            int start = Integer.parseInt(stringSplit[0]);
            int end = Integer.parseInt(stringSplit[1]);
            double weight = Double.parseDouble(stringSplit[2]);
            addEdge(new Edge(start, end, weight));
            E--;
        }
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(Edge edge) {
        // In an Undirected Graph, edge is added twice.
        int start = edge.start();
        int end = edge.end();
        adjacent[start].add(edge);
        adjacent[end].add(edge);
        E++;
    }

    public Iterable<Edge> adjacent(int v) { return adjacent[v]; }

    public Iterable<Edge> edges() {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < V; i++)
            result.addAll(adjacent[i]);
        return result;
    }
}
