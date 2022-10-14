package com.Github.IkhideIfidon;

import java.io.*;
import java.util.Iterator;
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
        int v = edge.start();
        int u = edge.end();
        adjacent[v].add(edge);
        adjacent[u].add(edge);
        E++;
    }

    public Iterable<Edge> adjacent(int v) { return adjacent[v]; }

    public Iterable<Edge> edges() {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < V; i++)
            result.addAll(adjacent[i]);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            sb.append(neighborsToString(i));

            for (Edge edge : adjacent[i]) {
                sb.append(edge.toString());
                sb.append("-->");
            }

            sb.append("\n");
        }
        return sb.toString();
    }

    public String neighborsToString(int v) {
        StringBuilder sb = new StringBuilder("[");

        Iterator<Edge> iter = adjacent[v].iterator();
        while (iter.hasNext()) {
            sb.append(iter.next());
            if (iter.hasNext())
                sb.append("-->");
        }
        sb.append("]");
        return sb.toString();
    }

}
