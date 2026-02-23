package yandex_leetcode.src.main.java.livecoding.special;

import java.util.Stack;

public class MinStack {
    private Node head;

    private class Node {
        int val;
        int min;
        Node next;

        public Node() {
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

    public void push(int val) {
       if (head == null) {
           head = new Node(val, val, null);
       } else {
           head = new Node(val, Math.min(val, head.min), head);
       }
    }

    public void pop() {
       head = head.next;
    }

    public int top() {
      return head.val;
    }

    public int getMin() {
     return head.min;
    }
}
