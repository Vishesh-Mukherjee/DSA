package com.example.DSA;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LinkedListTest {

    LinkedList linkedList;

    @BeforeEach
    void init() {
        linkedList = new LinkedList();
    }

    @Test
    void addMany() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        linkedList.addAll(list);
        assertThat(linkedList.toList()).isEqualTo(list);
    }

    @Test
    void addNone() {
        assertThat(linkedList.toList()).isEqualTo(Arrays.asList());
    }

    @Test
    void addOne() {
        List<Integer> list = Arrays.asList(1);
        linkedList.addAll(list);
        assertThat(linkedList.toList()).isEqualTo(list);
    }

    @Test
    void reverseMany() {
        linkedList.addAll(Arrays.asList(1, 2, 3, 4, 5));
        linkedList.reverse();
        assertThat(linkedList.toList()).isEqualTo(Arrays.asList(5, 4, 3, 2, 1));
    }

    @Test
    void reverseOne() {
        linkedList.addAll(Arrays.asList(1));
        linkedList.reverse();
        assertThat(linkedList.toList()).isEqualTo(Arrays.asList(1));
    }

    @Test
    void reverseNone() {
        linkedList.reverse();
        assertThat(linkedList.toList()).isEqualTo(Arrays.asList());
    }
}
