package yandex_leetcode.src.main.java.temp;

import java.util.HashMap;

public class ContainsDublicateII219 {
    public static void main(String[] args) {
        System.out.println(containsNearbyDublicate(new int[] {1,0,1,1}, 4));
    }

    public static boolean containsNearbyDublicate(int[] nums, int k) {
       HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i]) && (i - hashMap.get(nums[i]) <= k)) {
            return true;
        }
        hashMap.put(nums[i], i);
       }
        return false;
    }
}
