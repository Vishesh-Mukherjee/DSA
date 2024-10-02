package com.example.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeTraversal {

    public List<Integer> inOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.addAll(getLeftNodes(root));
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.getData());
            stack.addAll(getLeftNodes(current.getRight()));
        }
        return result;
    }

    public List<Integer> preOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.addAll(getLeftNodes(root, result));
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            stack.addAll(getLeftNodes(current.getRight()));
            getLeftNodes(current.getRight(), result);
        }
        return result;
    }

    public List<Node> getLeftNodes(Node node) {
        List<Node> leftNodes = new ArrayList<>();
        while (node != null) {
            leftNodes.add(node);
            node = node.getLeft();
        }
        return leftNodes;
    }

    public List<Node> getLeftNodes(Node node, List<Integer> data) {
        List<Node> leftNodes = new ArrayList<>();
        while (node != null) {
            leftNodes.add(node);
            data.add(node.getData());
            node = node.getLeft();
        }
        return leftNodes;
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
        result.add(node.getData());
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
        result.add(node.getData());
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
        result.add(node.getData());
    }

}
