package yandex_leetcode.src.main.java.livecoding.special;

import java.util.ArrayDeque;
import java.util.Deque;

public class HitCounter {

    private Deque<Integer> queue = new ArrayDeque<>();

    public HitCounter() {

    }

    public void hit(int timestamp) {
        queue.addLast(timestamp);
    }

    public int getHits(int timestamp) {
        while (queue.size() > 0 && timestamp - 300 >= queue.peekFirst()) {
            queue.removeFirst();
        }
        return queue.size();
    }

}
