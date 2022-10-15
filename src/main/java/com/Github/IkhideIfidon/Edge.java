package com.Github.IkhideIfidon;

@SuppressWarnings("ClassCanBeRecord")
public class Edge implements Comparable<Edge> {
    // Instance Variables
    private final int from;
    private final int to;
    private final double weight;

    // Constructor
    public Edge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() { return from; }
    public int to() { return to; }
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
        boolean compareStart = this.from() == that.from();
        if (!compareStart) return false;
        // Compare end
        boolean compareEnd = this.to() == that.to();
        if (!compareEnd) return false;
        // Compare weight
        return this.weight() == that.weight();
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = result + 31 * Integer.hashCode(from);
        result = result + 31 * Integer.hashCode(to);
        return result + 31 * Double.hashCode(weight);
    }

    @Override
    public String toString() {
        return String.format("[%d][%d][%.2f]", from(), to(), weight());
    }
}