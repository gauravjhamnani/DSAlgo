package com.algorithms.sorting;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1 ; i < n ; i++) {
            for (int j = i ; j > 0 ; j--) {
                if (SortUtil.less(a[j], a[j-1])) {
                    SortUtil.exchange(a, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
}
