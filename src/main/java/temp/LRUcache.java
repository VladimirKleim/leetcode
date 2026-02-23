package yandex_leetcode.src.main.java.temp;



import java.util.HashMap;
import java.util.Map;

class LRUcache {
    private Map<Integer,LinkedNode> content;
    private int capacity;
    private LinkedNode head, tail;
    private int size;



    public LRUcache(int capacity) {
       this.capacity = capacity;
       content = new HashMap(capacity);
       head = new LinkedNode();
       tail = new LinkedNode();
       head.next = tail;
       tail.prev = head;
    }

    public int get(int key) {
       LinkedNode element = content.get(key);
       if (element == null) {
           return -1;
       } else {
           remove(element);
           moveToHead(element);
       }
       return element.value;
    }

    public void put(int key, int value) {
        LinkedNode node = content.get(key);
        if(node != null) {
            node.value = value;
            remove(node);
            moveToHead(node);
        } else {
            node = new LinkedNode();
            node.value = value;
            node.key = key;
            content.put(key, node);
            moveToHead(node);
            size++;
            if (size > capacity) {
                content.remove(tail.prev.key);
                remove(tail.prev);
                size--;
            }
        }
    }
    private void moveToHead(LinkedNode node) {
        LinkedNode temp = head.next;
        head.next = node;
        node.prev = head;
        node.next = temp;
        temp.prev = node;
    }
    private void remove(LinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private class LinkedNode {
        int value;
        LinkedNode prev;
        LinkedNode next;
        int key;
    }
}

/**
 * Your LRUcache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */