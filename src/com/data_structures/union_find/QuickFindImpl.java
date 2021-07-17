package com.data_structures.union_find;

import java.util.HashSet;
import java.util.Set;

/**
 * Following is the Quick Find(Eager approach) implementation of Quick Union / Dynamic connectivity problem
 * Find operation is quick O(1)
 * Union operations is slow O(n)
 */
public class QuickFindImpl implements UnionFind {

    private int[] array;

    public QuickFindImpl(int n) {
        array = new int[n];
        for (int i = 0 ; i < n ; i++) {
            array[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        /*
         * Here storing array[p] and array[q] in temporary variable is very important, using them directly will become a problem as it might get
         * modified in between the loop
         */
        int posP = array[p];
        int posQ = array[q];
        if (p != q && posP != posQ) {
            for (int i = 0 ; i < array.length ; i++) {
                if (array[i] == posP) {
                    array[i] = posQ;
                }
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return array[p] == array[q];
    }

    @Override
    public int count() {
        Set<Integer> setOfIdentifiers = new HashSet<>();
        for (int i = 0 ; i < array.length ; i++) {
            setOfIdentifiers.add(array[i]);
        }
        return setOfIdentifiers.size();
    }
}
