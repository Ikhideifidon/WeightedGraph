package com.Github.IkhideIfidon;

public class Edge implements Comparable<Edge> {
    // Instance Variables
    private final int v;
    private final int w;
    private final double weight;

    // Constructor
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
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
    public int compareTo(Edge that) {
        // return this.weight > that.weight ? 1 : this.weight < that.weight ? -1 : 0;
        return Double.compare(this.weight, that.weight);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof Edge that)) return false;
        // Compare start
        boolean compareStart = this.either() == that.either();
        if (!compareStart) return false;
        // Compare end
        boolean compareEnd = this.other(v) == that.other(v);
        if (!compareEnd) return false;
        // Compare weight
        return this.weight() == that.weight();
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result + 31 * Integer.hashCode(v);
        result = result + 31 * Integer.hashCode(w);
        return result + 31 * Double.hashCode(weight);
    }

    @Override
    public String toString() {
        return String.format("[%d][%d][%.2f]", either(), other(v), weight());
    }
}