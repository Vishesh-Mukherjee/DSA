package com.example.dsa.algorithm;

import java.util.Collections;
import java.util.List;

public class Sorting {

    public List<Integer> bubbleSort(List<Integer> list) {
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        return list;
    }

    public List<Integer> selectionSort(List<Integer> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
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
        for (int i = 1; i < n; i++) {
            int temp = list.get(i);
            int j = i - 1;
            while (j >= 0) {
                if (list.get(j) > temp) {
                    list.set(j + 1, list.get(j));
                } else {
                    break;
                }
                j--;
            }
            list.set(j + 1, temp);
        }
        return list;
    }

    public List<Integer> mergeSort(List<Integer> list) {
        mergeSortDivide(list);
        return list;
    }

    private void mergeSortDivide(List<Integer> list) {
        int n = list.size();
        if (n <= 1) {
            return;
        }
        List<Integer> left = list.subList(0, n / 2);
        mergeSortDivide(left);
        List<Integer> right = list.subList(n / 2, n);
        mergeSortDivide(right);
        mergeSortConquer(list, left, right);
    }

    private void mergeSortConquer(List<Integer> list, List<Integer> left, List<Integer> right) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) < right.get(j)) {
                list.set(k, left.get(i));
                i++;
            } else {
                list.set(k, right.get(j));
                j++;
            }
            k++;
        }
        while (i < left.size()) {
            list.set(k, left.get(i));
            i++;
            k++;
        }
        while (j < right.size()) {
            list.set(k, right.get(j));
            j++;
            k++;
        }
    }

    public List<Integer> quickSort(List<Integer> list) {
        quickSortDivide(list, 0, list.size() - 1);
        return list;
    }

    private void quickSortDivide(List<Integer> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int index = quickSortConquer(list, left, right);
        quickSortDivide(list, left, index - 1);
        quickSortDivide(list, index + 1, right);
    }

    private int quickSortConquer(List<Integer> list, int left, int right) {
        int i = left;
        for (int j = left; j <= right; j++) {
            if (list.get(j) <= list.get(right)) {
                Collections.swap(list, i, j);
                i++;
            }
        }
        return i - 1;
    }
}
