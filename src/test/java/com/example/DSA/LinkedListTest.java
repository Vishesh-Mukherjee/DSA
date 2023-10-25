package com.example.DSA;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LinkedListTest {

    LinkedList linkedList;

    @BeforeEach
    void init() {
        linkedList = new LinkedList();
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testAdd(List<Integer> randomList) {
        linkedList.addAll(randomList);
        assertThat(linkedList.toList()).isEqualTo(randomList);
    }

    @ParameterizedTest
    @MethodSource("generateRandomList")
    void testReverse(List<Integer> randomList) {
        linkedList.addAll(randomList);
        linkedList.reverse();
        Collections.reverse(randomList);
        assertThat(linkedList.toList()).isEqualTo(randomList);
    }

    static Stream<Arguments> generateRandomList() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(1)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5))
        );
    }
}
