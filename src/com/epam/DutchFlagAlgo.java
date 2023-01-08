package com.epam;

import java.util.Arrays;

public class DutchFlagAlgo {
    private int[] A;

    public DutchFlagAlgo(int A[]) {
        this.A = A;
    }

    public void solve() {
        int pivot = 1;
        int i = 0, j = 0, k = A.length - 1;
        while (j <= k) {
            if (A[j] > pivot) {
                swap(j, k);
                --k;
            } else if (A[j] < pivot) {
                swap(i, j);
                i++;
                j++;
            } else j++;
        }
    }

    public void swap(int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }

    public void show() {
        System.out.println(Arrays.toString(A));
    }

    public int trapping() {
        int k = 1, L = A.length - 1, ans = 0;
        int[] maxLeft = new int[L + 1];
        int[] maxRight = new int[L + 1];
        maxRight[0] = A[L];
        for (int i = 1, j = L; i < L + 1 && j > -1; i++, j--, k++) {
            maxLeft[k] = Math.max(maxLeft[k - 1], A[i - 1]);
            maxRight[k] = Math.max(maxRight[k - 1], A[j]);
        }
        maxRight[L] = 0;
        for (int l = 1; l < L; l++) {
            int temp = Math.min(maxLeft[l], maxRight[l]) - A[l];
            if (temp > 0) ans += temp;
        }
        return ans;
    }

    public static void main(String[] args) {
        DutchFlagAlgo dutchFlagAlgo = new DutchFlagAlgo(new int[]{1, 2, 1, 1, 1, 0, 2, 0, 0, 1, 2, 1});
        dutchFlagAlgo.solve();
        dutchFlagAlgo.show();
        DutchFlagAlgo obj = new DutchFlagAlgo(new int[]{1, 0, 2, 1, 3, 1, 2, 0, 3});
        System.out.println(obj.trapping());
    }
}
