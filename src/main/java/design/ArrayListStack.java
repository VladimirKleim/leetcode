package yandex_leetcode.src.main.java.design;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack<T> {

    private List<T> list = new ArrayList<T>();

    public void push(T type) {
        list.add(type);
    }

    public T pop() {
        if (list.isEmpty()) {throw new EmptyStackException();}
        return list.remove(list.size() - 1);
    }

    public T peek() {
        if (list.isEmpty()) {throw new EmptyStackException();}
        return list.get(list.size() - 1);
    }
}
