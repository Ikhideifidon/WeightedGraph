package com.Github.IkhideIfidon;

import java.io.*;
import java.util.Deque;
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
        if (V > 0) {
            this.V = V;
            this.E = 0;
            //noinspection unchecked
            adjacent = (List<Edge>[]) new LinkedList[V];
            for (int v = 0; v < V; v++)
                adjacent[v] = new LinkedList<>();
        } else
            throw new ArrayIndexOutOfBoundsException("Number of Vertices cannot be less than 1.");
    }

    public EdgeWeightedGraph(BufferedReader in) throws IOException {
        this(Integer.parseInt(in.readLine()));
        this.E = Integer.parseInt(in.readLine());
        for (int i = 0; i < E(); i++) {
            // Add an edge
            String[] stringSplit = in.readLine().split("[ \\t]+"); // capture one or more space and tab
            int v = Integer.parseInt(stringSplit[0]);
            int w = Integer.parseInt(stringSplit[1]);
            double weight = Double.parseDouble(stringSplit[2]);
            addEdge(new Edge(v, w, weight));
            E--;
        }
    }

    // Copy Constructor
    public EdgeWeightedGraph(EdgeWeightedGraph that) {
        /*
            Instance Variables
            V    ............Immutable
            E    ............Immutable
            adjacent ........Mutable
         */
        this(that.V);

        Deque<Edge> queue = new LinkedList<>();
        for (int v = 0; v < this.V; v++) {
            for (Edge edge : that.neighbor(v)) {
                queue.offer(edge);
            }

            while (!queue.isEmpty())
                adjacent[v].add(queue.poll());

        }

        this.E = that.E;
    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(Edge edge) {
        // In an Undirected Graph, edge is added twice.
        int v = edge.either();
        int w = edge.other(v);
        adjacent[v].add(edge);
        adjacent[w].add(edge);
        E++;
    }

    public Iterable<Edge> neighbor(int v) {
        if (v >= 0 && v < V)
            return adjacent[v];
        else
            throw new ArrayIndexOutOfBoundsException("Inconsistent vertex");
    }

    @SuppressWarnings("unused")
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
