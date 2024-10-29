package com.example.dsa.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import com.example.dsa.util.LeftData;
import com.example.dsa.util.Node;

public class TreeTraversal {

    public List<Integer> inOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.addAll(getLeftData(root, 0).getLeftNodes());
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            result.add(currentNode.getValue());
            stack.addAll(getLeftData(currentNode.getRight(), 0).getLeftNodes());
        }
        return result;
    }

    public List<Integer> preOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        LeftData leftData = getLeftData(root, 0);
        stack.addAll(leftData.getLeftNodes());
        result.addAll(leftData.getLeftValues());
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            LeftData currentLeftData = getLeftData(currentNode.getRight(), 0);
            stack.addAll(currentLeftData.getLeftNodes());
            result.addAll(currentLeftData.getLeftValues());
        }
        return result;
    }

    public List<Integer> postOrderTraversalIteration(Node root) {
        List<Integer> result = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Set<Node> visitedNodes = new HashSet<>();
        stack.addAll(getLeftData(root, 0).getLeftNodes());
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            if (currentNode.hasRight() && !visitedNodes.contains(currentNode)) {
                visitedNodes.add(currentNode);
                stack.push(currentNode);
                stack.addAll(getLeftData(currentNode.getRight(), 0).getLeftNodes());
            } else {
                result.add(currentNode.getValue());
            }
        }
        return result;
    }

    private LeftData getLeftData(Node node, int baseHeight) {
        List<Node> leftNodes = new ArrayList<>();
        List<Integer> leftValues = new ArrayList<>();
        int count = 0;
        Map<Node, Integer> nodeHeight = new HashMap<>();
        while (node != null) {
            count ++;
            leftNodes.add(node);
            leftValues.add(node.getValue());
            nodeHeight.put(node, baseHeight+count);
            node = node.getLeft();
        }
        return new LeftData(leftNodes, leftValues, nodeHeight, count);
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

    public Map<Node, Integer> getNodesByHeight(Node root)  {
        Stack<Node> stack = new Stack<>();
        LeftData leftData = getLeftData(root, 0);
        stack.addAll(leftData.getLeftNodes());
        Map<Node, Integer> nodesByHeight = leftData.getNodesByHeight();
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            LeftData currentLeftData = getLeftData(currentNode.getRight(), nodesByHeight.get(currentNode));
            stack.addAll(currentLeftData.getLeftNodes());
            nodesByHeight.putAll(currentLeftData.getNodesByHeight());
        }
        return nodesByHeight;
   }

    public int getTreeHeight(Node root)  {
        Stack<Node> stack = new Stack<>();
        LeftData leftData = getLeftData(root, 0);
        int maxHeight = leftData.getLength();
        stack.addAll(leftData.getLeftNodes());
        Map<Node, Integer> nodeHeight = leftData.getNodesByHeight();
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            Integer baseHeight = nodeHeight.get(currentNode);
            LeftData currentLeftData = getLeftData(currentNode.getRight(), baseHeight);
            stack.addAll(currentLeftData.getLeftNodes());
            nodeHeight.putAll(currentLeftData.getNodesByHeight());
            if (baseHeight + currentLeftData.getLength() > maxHeight) {
                maxHeight = baseHeight + currentLeftData.getLength();
            }
        }
        return maxHeight;
   }

   public List<Integer> levelOrderTraversal(Node root) {
        List<Integer> result = new ArrayList<>(); 
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            result.add(currentNode.getValue());
            if (currentNode.hasLeft()) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.hasRight()) {
                queue.add(currentNode.getRight());
            }
        }
        return result;
   }

   public List<Integer> zigZagTraversal(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty() || !stack.empty()) {
            while (!queue.isEmpty()) {
                Node node = queue.remove();
                result.add(node.getValue());
                if (node.hasLeft()) {
                    stack.push(node.getLeft());
                }
                if (node.hasRight())  {
                    stack.push(node.getRight());
                }
            }
            while (!stack.isEmpty()) {
                Node node = stack.pop();
                result.add(node.getValue());
                if (node.hasRight())  {
                    queue.push(node.getRight());
                }
                if (node.hasLeft()) {
                    queue.push(node.getLeft());
                }

            }
        }
        return result;
   }
   /**
    * The horizontal distance of the left child of a node x is equal to a horizontal distance of x minus 1,
    * and that of a right child is the horizontal distance of x plus 1.
    * @param root
    * @return
    */
   public List<Integer> topView(Node root) {
        List<Integer> result = new ArrayList<>();
        LinkedList<Node> queue = new LinkedList<>();
        int currentPositive = 0;
        int currentNegative = 0;
        root.setPosition(0);
        queue.push(root);
        result.add(root.getValue());
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.getPosition() > currentPositive) {
                result.add(node.getValue());
                currentPositive = node.getPosition();
            }
            if (node.getPosition() < currentNegative) {
                result.add(node.getValue());
                currentNegative = node.getPosition();
            }
            if (node.hasLeft()) {
                node.getLeft().setPosition(node.getPosition() - 1);
                queue.add(node.getLeft());
            }
            if (node.hasRight()) {
                node.getRight().setPosition(node.getPosition() + 1);
                queue.add(node.getRight());
            }
        }
        return result;
   }

}
