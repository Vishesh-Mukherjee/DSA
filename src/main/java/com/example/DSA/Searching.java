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

    public int binarySearch(List<Integer> list, int ele) {
        int left = 0, right = list.size()-1;
        while (left <= right) {
            int mid = (left+right)/2;
            int midEle = list.get(mid);
            if (midEle == ele) {
                return mid;
            } else if (ele < midEle) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }
        return -1;
    }
}
