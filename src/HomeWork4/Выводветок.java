package HomeWork4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    void findBranches(Node node, List<Integer> branches) {
        if (node == null) {
            return;
        }

        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) {
            branches.add(node.data);
        }

        findBranches(node.left, branches);
        findBranches(node.right, branches);
    }

    void printBranches() {
        List<Integer> branches = new ArrayList<>();
        findBranches(root, branches);
        Collections.sort(branches);

        for (int branch : branches) {
            System.out.println(branch);
        }
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
        bst.printBranches();
        reader.close();
    }
}
