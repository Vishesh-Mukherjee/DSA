package com.example.dsa.util;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LeftData {
    private List<Node> leftNodes;
    private List<Integer> leftValues;
}
