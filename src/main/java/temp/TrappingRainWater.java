package yandex_leetcode.src.main.java.temp;

public class TrappingRainWater {
    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int sum = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax,height[l]);
                sum += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                sum += rightMax - height[r];
            }
        }
        return sum;
    }
}
