package yandex_leetcode.src.main.java.temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate217 {

    public static void main(String[] args) {
        System.out.println(containsDuplicate3(new int[]{1,2,3,4,5}));
        System.out.println(containsDuplicate3(new int[]{1,2,3,4,5,5}));
    }

    public static boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
      public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for (Integer num : nums) {
            if (temp.contains(num)) {
                return true;
            }
            temp.add(num);
        }
        return false;
      }

    public static boolean containsDuplicate3(int[] nums) {
        Set<Integer> temp = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (temp.size() != nums.length) {
            return true;
        } else {
            return false;
        }
    }
}
