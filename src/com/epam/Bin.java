package com.epam;

import java.util.ArrayList;
import java.util.List;

public class Bin {
    private int capacity;
    private List<Integer>items;
    private int id;
    private int actualSize;

    public Bin(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }
    public boolean put(Integer value) {
        if (actualSize+value > capacity) {
            return false;
        }
        items.add(value);
        actualSize += value;
        return true;
    }


    @Override
    public String toString() {
        String result = "The item of the bin is ";
        for (int i = 0; i < capacity; i++) {
            result += items.get(i) + " ";
        }return result;
    }
}
