package com.example.DSA;

import java.util.List;

public class Searching {

    public int linearSearch(List<Integer> list, int ele)  {
        int n = list.size();
        for (int i = 0; i < n; i ++) {
            if (list.get(i) == ele) {
                return i;
            }
        }
        return -1;
    }

}
