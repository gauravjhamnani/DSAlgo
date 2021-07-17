package com.data_structures.union_find;

/**
 * this implementation reduces root() function time complexity to log*n
 */
public class WeightedQuickUnionWithPathCompression extends WeightedQuickUnionImpl{

    public WeightedQuickUnionWithPathCompression(int n) {
        super(n);
    }

    @Override
    protected int root(int p) {
        while (super.parent[p] != p) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
}
