package com.data_structures.union_find;

public interface UnionFind {

    void union(int p, int q);

    boolean isConnected(int p, int q);

    int count();
}
