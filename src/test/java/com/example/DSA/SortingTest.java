package com.example.DSA;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortingTest {
    
    Sorting sort;

    @BeforeEach
    void init() {
        sort = new Sorting();
    }

    @Test
    void bubbleSortAscending() {
        assertThat(sort.bubbleSort(Arrays.asList(1, 2, 3, 4, 5))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void bubbleSortDescending() {
        assertThat(sort.bubbleSort(Arrays.asList(5, 4, 3, 2, 1))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test
    void bubbleSortEmpty() {
        assertThat(Arrays.asList()).isEqualTo(Arrays.asList());
    }

    @Test
    void bubbleSortRandom() {
        assertThat(sort.bubbleSort(Arrays.asList(1, 5, 2, 4, 3))).isEqualTo(Arrays.asList(1, 2, 3, 4, 5));
    }
}
