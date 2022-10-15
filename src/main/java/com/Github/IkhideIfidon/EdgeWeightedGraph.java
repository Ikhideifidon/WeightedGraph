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
        for (int i = 0; i < E(); i++) {
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
        int v = edge.from();
        int u = edge.to();
        adjacent[v].add(edge);
        adjacent[u].add(edge);
        E++;
    }

    public Iterable<Edge> neighbor(int v) { return adjacent[v]; }

    public Iterable<Edge> edges() {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < V(); i++) {
            result.addAll(adjacent[i]);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int v = 0; v < V; v++) {
            sb.append(String.format("\t[%d]", v));
            sb.append(" \u279E ");

            // If vertex 'i' has no neighbors
            if (adjacent[v].size() == 0)
                sb.append("[]");

            Iterator<Edge> iter = neighbor(v).iterator();
            while (iter.hasNext()) {
                sb.append(iter.next().toString());
                if (iter.hasNext())
                    sb.append("-->");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
