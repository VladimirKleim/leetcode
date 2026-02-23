package yandex_leetcode.src.main.java.livecoding.special;

import java.util.HashMap;
import java.util.Map;

public class LRUcache {

    Map<Integer, LinkedNode> map;
    private int capacity;
    private LinkedNode head, tail;
    private int size;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new LinkedNode();
        tail = new LinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
     LinkedNode element = map.get(key);
     if (element == null) {
         return -1;
     } else {
         remove(element);
         moveToHead(element);
     }
     return element.val;
    }

    public void put(int key, int val) {
        LinkedNode node = map.get(key);
        if (node != null) {
            node.next = node;
            remove(node);
            moveToHead(node);
        } else {
            node = new LinkedNode();
            node.val = val;
            node.key = key;
            map.put(key, node);
            moveToHead(node);
            size++;
            if (size > capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
        }
    }

    public void remove(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveToHead(LinkedNode node) {
        LinkedNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }


    private class LinkedNode {
        int val;
        LinkedNode prev;
        LinkedNode next;
        int key;

    }
}
