package com.example.DSA;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SortingTest {
    
    Sorting sorting;

    @BeforeEach
    void init() {
        sorting = new Sorting();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testBubbleSort(List<Integer> randomList) {
        assertThat(sorting.bubbleSort(randomList)).isSorted();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testSelectionSort(List<Integer> randomList) {
        assertThat(sorting.selectionSort(randomList)).isSorted();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testInsertionSort(List<Integer> randomList) {
        assertThat(sorting.insertionSort(randomList)).isSorted();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testMergeSort(List<Integer> randomList) {
        assertThat(sorting.mergeSort(randomList)).isSorted();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testQuickSort(List<Integer> randomList) {
        assertThat(sorting.quickSort(randomList)).isSorted();
    }

    static Stream<Arguments> generateRandomList() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(1)),
            Arguments.of(Arrays.asList(-1)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(5, 4, 3, 2, 1)),
            Arguments.of(Arrays.asList(1, 5, 2, 4, 3)),
            Arguments.of(Arrays.asList(-1, -2, -3, -4, -5)),
            Arguments.of(Arrays.asList(-5, -4, -3, -2, -1)),
            Arguments.of(Arrays.asList(-1, -5, -2, -4, -3)),
            Arguments.of(Arrays.asList(1, -2, 3, -4, 5)),
            Arguments.of(Arrays.asList(5, -4, 3, -2, 1)),
            Arguments.of(Arrays.asList(1, -5, 2, -4, 3)),
            Arguments.of(Arrays.asList(1, 2, -3, 4, 5, -1, 2, 3, -4, 5)),
            Arguments.of(Arrays.asList(5, 4, -3, 2, 1, -5, 4, 3, -2, 1)),
            Arguments.of(Arrays.asList(1, 5, -2, 4, 3, -1, 5, 2, -4, 3)),
            Arguments.of(Arrays.asList(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE)),
            Arguments.of(Arrays.asList(1, -5, Integer.MAX_VALUE, 2, Integer.MIN_VALUE, -4, 3))
        );
    }
}
