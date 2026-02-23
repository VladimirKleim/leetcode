package yandex_leetcode.src.main.java.livecoding.special;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineReflection {


    public boolean isReflect(int[][] points) {
        int xMin = Integer.MAX_VALUE;
        int xMax = Integer.MIN_VALUE;
        Set<List<Integer>> set = new HashSet<>();
        for (int[] point : points) {
            xMin = Math.min(xMin, point[0]);
            xMax = Math.max(xMax, point[0]);
            set.add(List.of(point[0], point[1]));
        }
        int sum = xMax + xMin;
        for (int[] point : points) {
            int reflect = sum - point[0];
            if (!set.contains(List.of(reflect, point[1]))) {
                return false;
            }
        }
        return true;
    }
}
