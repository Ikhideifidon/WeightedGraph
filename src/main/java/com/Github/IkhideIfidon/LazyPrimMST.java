package com.Github.IkhideIfidon;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class LazyPrimMST {
    // Instance Variables
    private final boolean[] marked;
    private final Deque<Edge> mst;
    private final PriorityQueue<Edge> priorityQueue;
    private double weight;

    // Constructor
    public LazyPrimMST(EdgeWeightedGraph G) {
        if (G == null)
            throw new NullPointerException("Edge Weighted Graph cannot be null");
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();      // Natural Order

        // Put all eligible edges in the mst
        visit(G, 0);
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int v = edge.either();
            int w = edge.other(v);
            if (marked[v] && marked[w])
                continue;
            mst.offer(edge);                            // Add edge to tree
            weight += edge.weight();
            if (!marked[v])
                visit(G, v);
            if (!marked[w])
                visit(G, w);
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        // Mark v and add to priorityQueue all edges from v to unmarked vertices
        marked[v] = true;
        for (Edge edge : G.neighbor(v)) {
            if (!marked[edge.other(v)])
                priorityQueue.offer(edge);
        }
    }

    public Iterable<Edge> edges() { return mst; }
    public double weight() { return weight; }
}
