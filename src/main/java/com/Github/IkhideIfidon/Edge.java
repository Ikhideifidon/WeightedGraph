package com.Github.IkhideIfidon;

public class Edge implements Comparable<Edge> {
    // Instance Variables
    private final int start;
    private final int end;
    private final double weight;

    // Constructor
    public Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int start() { return start; }
    public int end() { return end; }
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
        boolean compareStart = this.start() == that.start();
        if (!compareStart) return false;
        // Compare end
        boolean compareEnd = this.end() == that.end();
        if (!compareEnd) return false;
        // Compare weight
        return this.weight() == that.weight();
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result + 31 * Integer.hashCode(start);
        result = result + 31 * Integer.hashCode(end);
        return result + 31 * Double.hashCode(weight);
    }

    @Override
    public String toString() {
        return String.format("[%d][%d][%.2f]", start(), end(), weight());
    }
}