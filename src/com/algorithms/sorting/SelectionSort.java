package com.algorithms.sorting;

public class SelectionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0 ; i < n ; i++) {
            int min = i;
            for (int j = i + 1 ; j < n ; j++) {
                if (SortUtil.less(a[j], a[min])) {
                    min = j;
                }
            }
            SortUtil.exchange(a, i, min);
        }
    }
}
