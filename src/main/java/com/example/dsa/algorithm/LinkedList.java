package com.example.dsa.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.example.dsa.util.Node;

import lombok.Data;

@Data
public class LinkedList {
    private Node head;
    private Node tail;

    public Node addAll(List<Integer> list) {
        list.forEach(this::add);
        return head;
    }

    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
    }

    public void reverse() {
        Node current = head;
        Node previous = null;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public List<Integer> toList() {
        List<Integer> list = new ArrayList<>();
        Node pointer = head;
        while (pointer != null) {
            list.add(pointer.getValue());
            pointer = pointer.getNext();
        }
        return list;
    }
}
