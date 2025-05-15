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

    int insertWithDepth(Node node, int data, int depth) {
        if (node == null) {
            root = insert(root,data);
            return depth;
        }

        if (data < node.data) {
            if (node.left == null){
                root = insert(root,data);
                return depth + 1;
            }
            return insertWithDepth(node.left, data, depth + 1);

        } else if (data > node.data) {
            if (node.right == null){
                root = insert(root,data);
                return depth + 1;
            }
            return insertWithDepth(node.right, data, depth + 1);
        } else {
            return -1;
        }
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

    boolean contains(Node node, int data) {
        if (node == null) {
            return false;
        }

        if (data < node.data) {
            return contains(node.left, data);
        } else if (data > node.data) {
            return contains(node.right, data);
        } else {
            return true;
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

            if (!bst.contains(bst.root, num)) {
                int depth =  bst.insertWithDepth(bst.root, num, 1);
                bst.root = bst.insert(bst.root,num);
                System.out.println(depth);
            }


        }
        reader.close();
    }
}