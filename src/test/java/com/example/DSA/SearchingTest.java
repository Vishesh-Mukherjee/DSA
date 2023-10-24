package com.example.DSA;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class SearchingTest {

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
}
