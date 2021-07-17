package com.data_structures.union_find;

/**
 * This is Quick Union [lazy approach] algorithm for implementing union find data structure.
 * Union O(n)
 * isConnected O(n)
 */
public class QuickUnionImpl implements UnionFind {

    private int[] parent;

    public QuickUnionImpl(int n) {
        parent = new int[n];
        for (int i = 0 ; i < n ; i++) {
            parent[i] = i;
        }
    }

    private int root(int p) {
        while (parent[p] != p) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public void union(int p, int q) {
        parent[root(p)] = root(q);
    }

    @Override
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    @Override
    public int count() {
        int connectedComponentCount = 0;
        for (int i = 0; i < parent.length ; i++) {
            if (parent[i] == i) {
                connectedComponentCount++;
            }
        }
        return connectedComponentCount;
    }
}
