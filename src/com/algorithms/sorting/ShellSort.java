package com.algorithms.sorting;

/*
* This code uses (3*x + 1) h sequence
*
 */
public class ShellSort {

    public static void sort(Comparable[] a) {
        int h = findInitialH(a.length);
        while (h != 0) {
            hSortArray(a, h);
            h =  (h - 1) / 3;
        }
    }

    private static void hSortArray(Comparable[] a, int h) {
        for (int i = h ; i < a.length ; i++) {
            int  j = i;
            while ((j - h) >= 0 && SortUtil.less(a[j], a[j - h])) {
                SortUtil.exchange(a, j, j - h);
                j = j - h;
            }
        }
    }

    private static int findInitialH(int n) {
        int h = 1;
        while ((3 * h + 1) < n) {
            h = 3 * h + 1;
        }
        return h;
    }
}
