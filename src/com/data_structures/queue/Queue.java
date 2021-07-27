package com.data_structures.queue;

public interface Queue {

    public void enqueue(String item);

    public String dequeue();

    public int size();

    public boolean isEmpty();
}
