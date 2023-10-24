package com.example.DSA;

import java.util.Collections;
import java.util.List;

public class Sorting {
    public List<Integer> bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = n-1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (list.get(j) > list.get(j+1)) {
                    Collections.swap(list, j, j+1);
                }
            }
        }
        return list;
    }        
}
