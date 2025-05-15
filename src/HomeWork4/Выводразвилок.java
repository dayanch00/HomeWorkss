package HomeWork4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Main {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public static List<Integer> findNodesWithTwoChildren(Node root) {
        List<Integer> result = new ArrayList<>();
        findNodesWithTwoChildrenHelper(root, result);
        Collections.sort(result);
        return result;
    }

    private static void findNodesWithTwoChildrenHelper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            result.add(root.data);
        }

        findNodesWithTwoChildrenHelper(root.left, result);
        findNodesWithTwoChildrenHelper(root.right, result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        while (true) {
            int data = scanner.nextInt();
            if (data == 0) {
                break;
            }
            root = insert(root, data);
        }

        List<Integer> nodesWithTwoChildren = findNodesWithTwoChildren(root);
        for (int data : nodesWithTwoChildren) {
            System.out.println(data);
        }
    }
}

