package com.epam;

import java.util.Comparator;

public class Comp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        if (o2[1]>o1[1] ) {
            return 1;
        } else if (o2[1]==o1[1]) {
            return o2[0] - o1[0];
        }
        return -1;
    }
}
