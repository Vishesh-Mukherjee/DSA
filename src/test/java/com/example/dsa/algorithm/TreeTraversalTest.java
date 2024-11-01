package com.example.dsa.algorithm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.dsa.util.Node;

class TreeTraversalTest {

    Node n1;
    Node n2;
    Node n3;
    Node n4;
    Node n5;
    Node n6;
    Node n7;
    Node n8;
    Node n9;
    Node n10;

    Node root;

    TreeTraversal treeTraversal;

    @BeforeEach
    void init() {
        n7 = new Node(7, null, null);
        n8 = new Node(8, null, null);
        n9 = new Node(9, null, null);
        n10 = new Node(10, null, null);

        n3 = new Node(3, n7, null);
        n4 = new Node(4, n8, null);
        n5 = new Node(5, null, n9);
        n6 = new Node(6, null, n10);

        n1 = new Node(1, n3, n4);
        n2 = new Node(2, n5, n6);

        root = new Node(0, n1, n2);

        treeTraversal = new TreeTraversal();
    }

    @Test
    void testInOrderTraversalIteration() {
        assertThat(treeTraversal.inOrderTraversalIteration(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 1, 8, 4, 0, 5, 9, 2, 6, 10));
    }

    @Test
    void testPreOrderTraversalIteration() {
        assertThat(treeTraversal.preOrderTraversalIteration(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(0, 1, 3, 7, 4, 8, 2, 5, 9, 6, 10));
    }

    @Test
    void testPostOrderTraversalIteration() {
        assertThat(treeTraversal.postOrderTraversalIteration(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 8, 4, 1, 9, 5, 10, 6, 2, 0));
    }

    @Test
    void testInOrderTraversalRecursion() {
        assertThat(treeTraversal.inOrderTraversalRecursion(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 1, 8, 4, 0, 5, 9, 2, 6, 10));
    }

    @Test
    void testPreOrderTraversalRecursion() {
        assertThat(treeTraversal.preOrderTraversalRecursion(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(0, 1, 3, 7, 4, 8, 2, 5, 9, 6, 10));
    }

    @Test
    void testPostOrderTraversalRecursion() {
        assertThat(treeTraversal.postOrderTraversalRecursion(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 8, 4, 1, 9, 5, 10, 6, 2, 0));
    }

    @Test
    void testGetTreeHeight() {
        Node n11 = new Node(11);
        n9.setLeft(n11);
        assertThat(treeTraversal.getTreeHeight(root)).isEqualTo(5);
    }

    @Test
    void testGetNodesByHeight() {
        Node n11 = new Node(11);
        n9.setLeft(n11);
        assertThat(treeTraversal.getNodesByHeight(root))
        .isNotEmpty()
        .hasSize(12)
        .contains(
            entry(root, 1),
            entry(n1,2),
            entry(n2, 2),
            entry(n3, 3),
            entry(n4, 3),
            entry(n5, 3),
            entry(n6, 3),
            entry(n7, 4),
            entry(n8, 4),
            entry(n9, 4),
            entry(n10, 4),
            entry(n11, 5)
        );
    }

    @Test
    void testLevelOrderTraversal() {
        assertThat(treeTraversal.levelOrderTraversal(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    @Test
    void testZigZagTraversal() {
        assertThat(treeTraversal.zigZagTraversal(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(0, 2, 1, 3, 4, 5, 6, 10, 9, 8, 7));
    }

    @Test
    void testTopView() {
        Node tvn13 = new Node(13, null, null);
        Node tvn14 = new Node(14, null, null);
        Node tvn11 = new Node(11, tvn13, null);
        Node tvn12 = new Node(12, null, tvn14);

        Node tvn9 = new Node(9, tvn11, null);
        Node tvn10 = new Node(10, null, tvn12);
        Node tvn7 = new Node(7, tvn9, null);
        Node tvn8 = new Node(8, null, tvn10);

        Node tvn3 = new Node(3, tvn7, null);
        Node tvn4 = new Node(4, tvn7, tvn8);
        Node tvn5 = new Node(5, null, null);
        Node tvn6 = new Node(6, null, null);

        Node tvn1 = new Node(1, tvn5, tvn3);
        Node tvn2 = new Node(2, tvn4, tvn6);

        Node tvnRoot = new Node(0, tvn1, tvn2);
        assertThat(treeTraversal.topView(tvnRoot))
        .isNotEmpty()
        .hasSize(9)
        .isEqualTo(List.of(0, 1, 2, 5, 6, 11, 12, 13, 14));
    }

    @Test
    void testLeftView() {
        Node n16 = new Node(16, null, null);
        Node n15 = new Node(15, null, n16);
        Node n14 = new Node(14, null, n15);
        Node n13 = new Node(13, null, null);
        Node n12 = new Node(12, n13, null);
        Node n11 = new Node(11, null, null);

        n9.setLeft(n11);
        n9.setRight(n12);
        n10.setRight(n14);

        assertThat(treeTraversal.leftView(root))
        .isNotEmpty()
        .hasSize(7)
        .isEqualTo(List.of(0, 1, 3, 7, 11, 13, 16));
    }

    @Test
    void testBinaryTree() {
        Node rootNode = treeTraversal.createBinaryTree(List.of(4, 2, 1, 3, 6, 5, 7));
        assertThat(rootNode.getValue()).isEqualTo(4);
        assertThat(rootNode.getLeft().getValue()).isEqualTo(2);
        assertThat(rootNode.getLeft().getLeft().getValue()).isEqualTo(1);
        assertThat(rootNode.getLeft().getRight().getValue()).isEqualTo(3);
        assertThat(rootNode.getRight().getValue()).isEqualTo(6);
        assertThat(rootNode.getRight().getLeft().getValue()).isEqualTo(5);
        assertThat(rootNode.getRight().getRight().getValue()).isEqualTo(7);
    }

}

