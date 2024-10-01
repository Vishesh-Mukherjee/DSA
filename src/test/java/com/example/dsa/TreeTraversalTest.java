package com.example.dsa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreeTraversalTest {

    Node root;
    TreeTraversal treeTraversal;

    @BeforeEach
    void init() {
        Node n7 = new Node(7, null, null);
        Node n8 = new Node(8, null, null);
        Node n9 = new Node(9, null, null);
        Node n10 = new Node(10, null, null);

        Node n3 = new Node(3, n7, null);
        Node n4 = new Node(4, n8, null);
        Node n5 = new Node(5, null, n9);
        Node n6 = new Node(6, null, n10);

        Node n1 = new Node(1, n3, n4);
        Node n2 = new Node(2, n5, n6);

        root = new Node(0, n1, n2);

        treeTraversal = new TreeTraversal();
    }

    @Test
    void testInOrderTraversal() {
        assertThat(treeTraversal.inOrderTraversal(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 1, 8, 4, 0, 5, 9, 2, 6, 10));
    }

    @Test
    void testPreOrderTraversal() {
        assertThat(treeTraversal.preOrderTraversal(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(0, 1, 3, 7, 4, 8, 2, 5, 9, 6, 10));
    }

    @Test
    void testPostOrderTraversal() {
        assertThat(treeTraversal.postOrderTraversal(root))
        .isNotEmpty()
        .hasSize(11)
        .isEqualTo(List.of(7, 3, 8, 4, 1, 9, 5, 10, 6, 2, 0));
    }

}

