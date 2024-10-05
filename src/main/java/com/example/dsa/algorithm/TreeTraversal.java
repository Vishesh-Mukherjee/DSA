package com.example.dsa.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import com.example.dsa.util.LeftData;
import com.example.dsa.util.Node;

public class TreeTraversal {

    public List<Integer> inOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.addAll(getLeftData(root).getLeftNodes());
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.getValue());
            stack.addAll(getLeftData(current.getRight()).getLeftNodes());
        }
        return result;
    }

    public List<Integer> preOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        LeftData leftData = getLeftData(root);
        stack.addAll(leftData.getLeftNodes());
        result.addAll(leftData.getLeftValues());
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            LeftData currentLeftData = getLeftData(current.getRight());
            stack.addAll(currentLeftData.getLeftNodes());
            result.addAll(currentLeftData.getLeftValues());
        }
        return result;
    }

    public List<Integer> postOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        stack.addAll(getLeftData(root).getLeftNodes());
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.hasRight() && !visited.contains(current)) {
                visited.add(current);
                stack.push(current);
                stack.addAll(getLeftData(current.getRight()).getLeftNodes());
            } else {
                result.add(current.getValue());
            }
        }
        return result;
    }

    private LeftData getLeftData(Node node) {
        List<Node> leftNodes = new ArrayList<>();
        List<Integer> leftData = new ArrayList<>();
        while (node != null) {
            leftNodes.add(node);
            leftData.add(node.getValue());
            node = node.getLeft();
        }
        return new LeftData(leftNodes, leftData);
    }

    public List<Integer> inOrderTraversalRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        inOrderHelper(root, result);
        return result;
    }

    private void inOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inOrderHelper(node.getLeft(), result);
        result.add(node.getValue());
        inOrderHelper(node.getRight(), result);
    }

    public List<Integer> preOrderTraversalRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        preOrderHelper(root, result);
        return result;
    }

    private void preOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.getValue());
        preOrderHelper(node.getLeft(), result);
        preOrderHelper(node.getRight(), result);
    }

    public List<Integer> postOrderTraversalRecursion(Node root) {
        List<Integer> result = new ArrayList<>();
        postOrderHelper(root, result);
        return result;
    }

    private void postOrderHelper(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postOrderHelper(node.getLeft(), result);
        postOrderHelper(node.getRight(), result);
        result.add(node.getValue());
    }

}
