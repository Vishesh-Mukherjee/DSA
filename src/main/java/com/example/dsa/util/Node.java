package com.example.dsa.util;

import lombok.Data;

@Data
public class Node {
    private int value;
    private Node left;
    private Node right;
    private Node next;
    private int position;

    public Node(int data) {
        this.value = data;
    }

    public Node(int data, Node left, Node right) {
        this.value = data;
        this.left = left;
        this.right = right;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
