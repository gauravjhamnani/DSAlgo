package com.data_structures.queue;

public class QueueResizeArrayImpl implements Queue {

    private String[] a;

    private int cap;

    private int front;

    private int rear;

    public QueueResizeArrayImpl() {
        a = new String[1];
        this.cap = 1;
        rear = -1;
        front = 0;
    }

    @Override
    public void enqueue(String item) {
        if (size() >= cap) {
            resize(2 * cap);
        }
        a[(++rear) % cap] = item;
    }

    @Override
    public String dequeue() {
        if (size() > 0) {
            String item = a[(front++) % cap];
            if (size() < (cap / 4)) {
                resize(cap / 2);
            }
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

    private void resize(int cap) {
        System.out.println(cap);
        String[] newArray = new String[cap];
        int cnt = 0;
        while (size() != 0) {
            newArray[cnt++] = a[(front++) % cap];
        }
        a = newArray;
        front = 0;
        rear = cnt - 1;
        this.cap = cap;
    }

    public static void main(String[] args) {
        QueueResizeArrayImpl obj = new QueueResizeArrayImpl();
        obj.enqueue("First");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.enqueue("Second");
        obj.dequeue();
        obj.enqueue("third");
        while (!obj.isEmpty())
            obj.dequeue();
    }
}
