package com.Github.IkhideIfidon;

public class Edge implements Comparable<Edge> {
    // Instance Variables
    private final int v;
    private final int w;
    private final double weight;                    // Negative edge weights are allowed.

    // Constructor
    public Edge(int v, int w, double weight) {
        if (v >= 0 && w >= 0) {
            this.v = v;
            this.w = w;
            this.weight = weight;
        } else
            throw new IllegalArgumentException("Inconsistent Vertices");
    }

    public int either() { return v; }
    public int other(int vertex) {
        if (vertex == v) return w;
        else if (vertex == w) return v;
        else
            throw new IllegalArgumentException("Inconsistent Edge");
    }
    public double weight() { return weight; }

    @Override
    // Comparison of edges is only ideally defined on the weights.
    public int compareTo(Edge that) {
        // return this.weight > that.weight ? 1 : this.weight < that.weight ? -1 : 0;
        return Double.compare(this.weight, that.weight);
    }

    @Override
    // The equality of this edge is determined by the weight only
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Edge that)) return false;
        // Compare weight
        return this.weight() == that.weight();
    }

    @Override
    // The hashCode is weight dependent only
    public int hashCode() {
        int result = 0;
        return result + 31 * Double.hashCode(weight);
    }

    @Override
    public String toString() {
        return String.format("[%d][%d][%.2f]", either(), other(v), weight());
    }
}