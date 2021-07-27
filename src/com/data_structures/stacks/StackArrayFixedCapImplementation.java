package com.data_structures.stacks;


/**
 * Advantages
 * Object overhead is not there from memory perspective as compared to linked list
 * Disadvantages
 * Considerations to take for overflow and underflow
 */
public class StackArrayFixedCapImplementation implements Stack {

    private String a[];

    private int currPos;

    public StackArrayFixedCapImplementation(int cap) {
        a = new String[cap];
        currPos = -1;
    }

    @Override
    public void push(String item) {
        if (currPos < (a.length - 1)) {
            a[++currPos] = item;
        } else {
            // Cap exceeded exception
        }
    }

    @Override
    public String pop() {
        if (!isEmpty()) {
            String item = a[currPos];
            a[currPos--] = null;
            return item;
        } else {
            return null;
        }
    }

    @Override
    public String top() {
        if (!isEmpty()) {
            return a[currPos];
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        return (currPos == -1);
    }

    @Override
    public int size() {
        return currPos + 1;
    }
}
