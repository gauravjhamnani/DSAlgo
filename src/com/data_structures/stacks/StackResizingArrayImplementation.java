package com.data_structures.stacks;

public class StackResizingArrayImplementation implements Stack {

    private String a[];

    private int currPos;

    public StackResizingArrayImplementation() {
        a = new String[1];
        currPos = -1;
    }

    @Override
    public void push(String item) {
        if (currPos == (a.length - 1)) {
            resize(2 * a.length);
        }
        a[++currPos] = item;
    }

    @Override
    public String pop() {
        if (currPos == -1) {
            return null;
        }
        String item = a[currPos];
        a[currPos--] = null;
        if (currPos == a.length/4) {
            resize(a.length/2);
        }
        return item;
    }

    @Override
    public String top() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return (currPos == -1);
    }

    @Override
    public int size() {
        return currPos + 1;
    }

    private void resize(int capacity) {
//        System.out.println("RESIZING to " + capacity);
        String copy[] = new String[capacity];
        for (int i = 0 ; i <= currPos ; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    private void emptyStackAndPrint() {
        while (!isEmpty()) {
            System.out.println(pop());
        }
    }

    public static void main(String[] args) {
        StackResizingArrayImplementation obj = new StackResizingArrayImplementation();
        for (int i = 65 ; i < 90 ;i++) {
            obj.push("Gaurav_" + (char)i);
        }
        obj.emptyStackAndPrint();
    }
}
