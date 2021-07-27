package com.data_structures.queue;

import java.util.Objects;

public class QueueLinkedListImpl implements Queue {

    private Node front;

    private Node rear;

    private int size;

    private class Node {
        Node next;
        String item;

        public Node(String item) {
            this.next = null;
            this.item = item;
        }
    }

    public QueueLinkedListImpl() {
        front = null;
        rear = null;
        size = 0;
    }

    @Override
    public void enqueue(String item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    @Override
    public String dequeue() {
        if (isEmpty()) {
            return null;
        }
        if (size() == 1) {
            rear = null;
        }
        String item = front.item;
        front = front.next;
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(front);
    }

    public static void main(String[] args) {
        QueueLinkedListImpl obj = new QueueLinkedListImpl();
        obj.enqueue("First");
        obj.enqueue("Second");
        obj.enqueue("third");
        int cnt = 3;
        while ((cnt--) > 0)
        System.out.println(obj.dequeue());
    }
}
