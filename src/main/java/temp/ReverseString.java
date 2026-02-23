package yandex_leetcode.src.main.java.temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseString {
    public static void main(String[] args) {


        char[] res = new char[]{'h','e','g','m'};
        reverseString(res);
        System.out.println(res);
        System.out.println(Arrays.toString(intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));

    }
    public static void reverseString(char[] s) {
      int left = 0, right = s.length - 1;
      while (left < right) {
          char temp = s[left];
          s[left] = s[right];
          s[right] = temp;
          left++;
          right--;
      }
    }
    public static int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (Integer num : nums1) {
            set1.add(num);
        }
        for (Integer num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for (Integer num : set2) {
            arr[i++] = num;

        }

        return arr;
    }
}
