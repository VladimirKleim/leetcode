package yandex_leetcode.src.main.java.temp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineReflection {
    public static void main(String[] args) {
        int[][] points = {
                {1,1},
                {1,3},
                {-1,1},
                {-1,3},
                {0,0}
        };
        System.out.println(lineReflection(points));
    }


    public static boolean lineReflection(int[][] nums) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        //Множество
        Set<List<Integer>> points = new HashSet<>();
        for (int[] point : nums) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);
            points.add(List.of(point[0], point[1]));
        }
        int sum = maxX + minX;
        for (int[] point : nums) {
            if (!points.contains(List.of(sum - point[0], point[1]))) {
                return false;
            }
        }
        return true;
    }
}
