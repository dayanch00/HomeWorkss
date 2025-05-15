package HomeWork4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root = null;
    }

    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    int height(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }

    boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int heightDiff = Math.abs(leftHeight - rightHeight);

        if (heightDiff > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    boolean isBalanced() {
        return isBalanced(root);
    }
}

public class main {
    public static void main(String[] args) throws IOException {
        BinarySearchTree bst = new BinarySearchTree();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String[] parts;
        int num;

        line = reader.readLine();
        parts = line.split(" ");

        for (String part : parts) {
            num = Integer.parseInt(part);
            if (num == 0) break;
            bst.root = bst.insert(bst.root, num);
        }

        boolean balanced = bst.isBalanced();
        System.out.println(balanced ? "YES" : "NO");

        reader.close();
    }
}