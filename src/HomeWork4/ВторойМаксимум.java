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


    Node findLargest(Node node) {
        if (node == null) return null;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    int findSecondLargest() {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }

        Node current = root;
        Node parent = null;

        while (current.right != null) {
            parent = current;
            current = current.right;
        }

        if (current.left != null) {
            return findLargest(current.left).data;
        }


        return parent.data;
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

        int secondLargest = bst.findSecondLargest();
        System.out.println(secondLargest);

        reader.close();
    }
}

