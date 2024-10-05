package com.example.dsa.algorithm;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchingTest {

    Searching searching;

    @BeforeEach
    void init() {
        searching = new Searching();
    }

    @Test
    void linearSearchElementPresent() {
        List<Integer> list = Arrays.asList(1, 5, 2, 4, 3);
        assertThat(searching.linearSearch(list, 4)).isEqualTo(3);
    }

    @Test
    void linearSearchElementAbsent() {
        List<Integer> list = Arrays.asList(1, 5, 2, 4, 3);
        assertThat(searching.linearSearch(list, 0)).isEqualTo(-1);
    }

    @Test
    void binarySearchElementPresent() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThat(searching.binarySearch(list, 5)).isEqualTo(4);
    }

    @Test
    void binarySearchElementAbsent() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        assertThat(searching.binarySearch(list, 0)).isEqualTo(-1);
    }
}
