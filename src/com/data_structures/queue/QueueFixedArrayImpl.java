package com.data_structures.queue;

public class QueueFixedArrayImpl implements Queue {

    private String[] a;

    private int cap;

    private int front;

    private int rear;

    public QueueFixedArrayImpl(int cap) {
        a = new String[cap];
        this.cap = cap;
        rear = -1;
        front = 0;
    }

    @Override
    public void enqueue(String item) {
        if (size() < cap) {
            a[(++rear) % cap] = item;
        }
    }

    @Override
    public String dequeue() {
        if (size() > 0) {
            String item = a[(front++) % cap];
            return item;
        }
        return null;
    }

    @Override
    public int size() {
        return rear - front + 1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public static void main(String[] args) {
        QueueFixedArrayImpl obj = new QueueFixedArrayImpl(30);
        obj.enqueue("First");
        obj.dequeue();
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.dequeue();
        obj.enqueue("third");
        while (!obj.isEmpty())
            System.out.println(obj.dequeue());
    }
}
