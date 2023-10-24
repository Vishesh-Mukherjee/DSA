package com.example.DSA;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingTest {
    
    Sorting sorting;

    @BeforeEach
    void init() {
        sorting = new Sorting();
    }

    @Test
    void bubbleSortAscending() {
        assertThat(sorting.bubbleSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void bubbleSortDescending() {
        assertThat(sorting.bubbleSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void bubbleSortEmpty() {
        assertThat(sorting.bubbleSort(Arrays.asList())).isEqualTo(Arrays.asList());
    }

    @Test
    void bubbleSortRandom() {
        assertThat(sorting.bubbleSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void selectionSortAscending() {
        assertThat(sorting.selectionSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void selectionSortDescending() {
        assertThat(sorting.selectionSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void selectionSortEmpty() {
        assertThat(sorting.selectionSort(Arrays.asList())).isEqualTo(Arrays.asList());
    }

    @Test
    void selectionSortRandom() {
        assertThat(sorting.selectionSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void insertionSortAscending() {
        assertThat(sorting.insertionSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void insertionSortDescending() {
        assertThat(sorting.insertionSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void insertionSortEmpty() {
        assertThat(sorting.insertionSort(Arrays.asList())).isEqualTo(Arrays.asList());
    }

    @Test
    void insertionSortRandom() {
        assertThat(sorting.insertionSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void mergeSortAscending() {
        assertThat(sorting.mergeSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void mergeSortDescending() {
        assertThat(sorting.mergeSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void mergeSortEmpty() {
        assertThat(sorting.mergeSort(Arrays.asList())).isEqualTo(Arrays.asList());
    }

    @Test
    void mergeSortRandom() {
        assertThat(sorting.mergeSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void quickSortAscending() {
        assertThat(sorting.quickSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void quickSortDescending() {
        assertThat(sorting.quickSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void quickSortEmpty() {
        assertThat(sorting.quickSort(Arrays.asList())).isEqualTo(Arrays.asList());
    }

    @Test
    void quickSortRandom() {
        assertThat(sorting.quickSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }
}
