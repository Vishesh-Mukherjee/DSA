package com.example.dsa;

import lombok.Data;

@Data
public class Node {
    private int data;
    private Node left;
    private Node right;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
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
        return String.valueOf(data);
    }
}
