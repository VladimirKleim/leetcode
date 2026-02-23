package yandex_leetcode.src.main.java.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArr2 {
    public static void main(String[] args) {

    }
    public static int[] intersect(int[] nums1, int[] nums2) {
     Map<Integer, Integer> map = new HashMap<>();
     for (Integer num : nums1) {
         map.put(num, map.getOrDefault(num, 0) + 1);
     }
     List<Integer> list = new ArrayList<>();
     for (Integer num : nums2) {
         if(map.containsKey(num) && map.get(num) > 0) {
             list.add(num);
             map.put(num, map.get(num) - 1);
         }
     }
     int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
