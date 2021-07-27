package com.data_structures.stacks;

import java.util.Objects;

public class StackLinkedListImpl implements Stack {

    private class Node {
        Node next;
        String item;

        Node(Node next, String item) {
            this.next = next;
            this.item = item;
        }
    }

    private Node currNode;

    private int size;

    public StackLinkedListImpl() {
        this.currNode = null;
        this.size = 0;
    }

    @Override
    public void push(String item) {
        Node newNode = new Node(currNode, item);
        currNode = newNode;
        size++;
    }

    @Override
    public String pop() {
        if (Objects.isNull(currNode)) {
            return null;
        }
        Node topMostStackNode = currNode;
        currNode = currNode.next;
        size--;
        return topMostStackNode.item;
    }

    @Override
    public String top() {
        if (Objects.isNull(currNode)) {
            return null;
        }
        return currNode.item;
    }

    @Override
    public boolean isEmpty() {
        return Objects.isNull(currNode);
    }

    @Override
    public int size() {
        return this.size;
    }

    private void emptyStackAndPrint() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }
}
