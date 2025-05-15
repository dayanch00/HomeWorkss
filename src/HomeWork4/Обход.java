package HomeWork4;

import java.util.Scanner;

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

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }
}

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);

        int num;
        while (scanner.hasNextInt() && (num = scanner.nextInt()) != 0) {
            bst.root = bst.insert(bst.root, num);
        }

        bst.inorder(bst.root);
        scanner.close();
    }
}
