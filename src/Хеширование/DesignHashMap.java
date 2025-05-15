package Хеширование;

class MyHashMap {

    private static final int SIZE = 1000;
    private Node[] map;

    public MyHashMap() {
        map = new Node[SIZE];
    }

    private int hash(int key) {
        return Integer.hashCode(key) % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = map[index];


        Node current = head;
        while (current != null) {
            if (current.key == key) {
                current.value = value;
                return;
            }
            current = current.next;
        }


        Node newNode = new Node(key, value);
        newNode.next = head;
        map[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        Node head = map[index];

        Node current = head;
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node head = map[index];


        if (head != null && head.key == key) {
            map[index] = head.next;
            return;
        }

        Node current = head;
        Node prev = null;

        while (current != null && current.key != key) {
            prev = current;
            current = current.next;
        }


        if (current == null) {
            return;
        }


        prev.next = current.next;
    }


    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

//p