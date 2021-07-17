package com.data_structures.union_find;

/**
 * implementation of weighted quick union algorithm.
 * union O(log(n))
 * isConnected O(log(n))
 */
public class WeightedQuickUnionImpl implements UnionFind {

    protected int[] parent;

    private int[] size;

    public WeightedQuickUnionImpl(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    protected int root(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int count() {
        int connectedComponents = 0;
        for (int i = 0 ; i < parent.length ; i++) {
            if (parent[i] == i) {
                connectedComponents++;
            }
        }
        return connectedComponents;
    }
}
