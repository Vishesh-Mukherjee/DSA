package com.example.dsa;

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
            int minIndex = i;
            for (int j = i; j < n; j ++) {
                if (list.get(j) < list.get(minIndex)) {
                    minIndex = j;
                }
            }
            Collections.swap(list, i, minIndex);
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
        int i = 0;
        int j = 0;
        int k = 0;
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

    public List<Integer> quickSort(List<Integer> list) {
        quickSortDivide(list, 0, list.size()-1);
        return list;
    }

    private void quickSortDivide(List<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = quickSortConquer(list, left, right);
        quickSortDivide(list, left, index-1);
        quickSortDivide(list, index+1, right);
    }

    private int quickSortConquer(List<Integer> list, int left, int right) {
        int i = left;
        for (int j = left; j <= right; j ++) {
            if (list.get(j) <= list.get(right)) {
                Collections.swap(list, i, j);
                i ++;
            }
        }
        return i-1;
    }
}
