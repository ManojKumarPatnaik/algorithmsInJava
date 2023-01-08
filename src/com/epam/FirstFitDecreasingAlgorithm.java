package com.epam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class FirstFitDecreasingAlgorithm {
    private int size;
    private List<Integer> items;
    private List<Bin> bins;
    private int binCounter = 1;

    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        FirstFitDecreasingAlgorithm firstFitDecreasingAlgorithm = new FirstFitDecreasingAlgorithm(list, 8);
//        firstFitDecreasingAlgorithm.solve();
//        firstFitDecreasingAlgorithm.show();
        double a=24,b=11,c=a/b;
        var l = new ArrayList<Integer>();
        Collections.sort(l);
        l.stream().collect(Collectors.averagingDouble(Integer::intValue));
        double count = (long) l.size();
        System.out.println(24/11);
        System.out.println(c);

    }

    private void solve() {
        Collections.sort(items, Comparator.reverseOrder());
        if (items.get(0) > size) {
            System.out.println("No solution found");
            return;
        }
        bins.add(new Bin(binCounter, size));
        for (var item : items) {
            boolean isOk = false;
            int current = 0;
            while (!isOk) {
                binCounter++;
                if (current == bins.size()) {
                    var b = new Bin(++binCounter, size);
                    b.put(item);
                    bins.add(b);
                    isOk = true;
                } else if (bins.get(current).put(item)) {
                    isOk = true;
                } else current++;
            }
        }
    }

    public void show() {
        bins.forEach(System.out::println);
    }


    public FirstFitDecreasingAlgorithm(List<Integer> items, int size) {
        this.items = items;
        this.size = size;
        this.bins = new ArrayList<>(items.size());
    }
}
