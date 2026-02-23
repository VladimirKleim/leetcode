package yandex_leetcode.src.main.java.temp;

import java.util.Arrays;

public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -2, 1, 3, 5})));
    }

    //Method 2 Points (2 указателя на левую и правую части)

    public static int[] sortedSquares(int[] nums) {
        int lP = 0, rP = nums.length - 1;
        int[] sortedArray = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int left = Math.abs(nums[lP]);
            int right = Math.abs(nums[rP]);

            if (left > right) {
                sortedArray[i] = left * left;
                lP++;
            } else {
                sortedArray[i] = right * right;
                rP--;
            }
        }
        return sortedArray;
    }
}
