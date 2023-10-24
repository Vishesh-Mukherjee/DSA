package com.example.DSA;

import java.util.ArrayList;
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

    public List<Integer> selectionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n; i ++) {
            int min_index = i;
            for (int j = i; j < n; j ++) {
                if (list.get(j) < list.get(min_index)) {
                    min_index = j;
                }
            }
            Collections.swap(list, i, min_index);
        }
        return list;
    }

    public List<Integer> insertionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 1; i < n; i ++) {
            int temp = list.get(i);
            int j = i-1;
            while(j >= 0) {
                if (list.get(j) > temp) {
                    list.set(j+1, list.get(j));
                } else {
                    break;
                }
                j --;
            }
            list.set(j+1, temp);
        }
        return list;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        mergeSortDivide(list);
        return list;
    }

    private void mergeSortDivide(List<Integer> list) {
        if (list.size() <= 1) {
            return;
        }
        int n = list.size();
        int mid = n/2;
        List<Integer> leftList = new ArrayList<>();
        for (int i = 0; i < mid; i ++) {
            leftList.add(list.get(i));
        }
        mergeSortDivide(leftList);
        List<Integer> rightList = new ArrayList<>();
        for (int i = mid; i < n; i ++) {
            rightList.add(list.get(i));
        }
        mergeSortDivide(rightList);
        mergeSortConquer(list, leftList, rightList);
    }

    private void mergeSortConquer(List<Integer> list, List<Integer> leftList, List<Integer> rightList) {
        int i = 0, j = 0, k = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (leftList.get(i) < rightList.get(j)) {
                list.set(k, leftList.get(i));
                i ++;
            } else {
                list.set(k, rightList.get(j));
                j ++;
            }
            k ++;
        }
        while (i < leftList.size()) {
            list.set(k, leftList.get(i));
            i ++;
            k ++;
        }
        while (j < rightList.size()) {
            list.set(k, rightList.get(j));
            j ++;
            k ++;
        }
    }
}
