package yandex_leetcode.src.main.java.design;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class LinkedListStack<T> {

    private LinkedList<T> list = new LinkedList<>();

    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        if (list.isEmpty()) {throw new EmptyStackException();}
        return list.removeFirst();
    }

    public T peek() {
        if (list.isEmpty()) {throw new EmptyStackException();}
        return list.getFirst();
    }

    // O(n) ---> O(1)
    // [1] -> [2,1] -> [3,2,1]
}
