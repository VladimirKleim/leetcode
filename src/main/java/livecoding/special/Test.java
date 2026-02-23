package yandex_leetcode.src.main.java.livecoding.special;

import yandex_leetcode.src.main.java.livecoding.Coding;

import java.util.*;

public class Test {

    public static void main(String[] args) {
        Coding coding = new Coding();
        merge(new int[]{1,2,3,0,0}, 2, new int[]{1,4,0}, 1);
        //
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums1) {
            if (num == 0) {
                m--;
            }
            set1.add(num);
        }
        for (Integer num : nums2) {
            if (num == 0) {
                n--;
            }
            set2.add(num);
        }
        for (Integer num : set1) {
            list.add(num);
        }
        for (Integer num : set2) {
            list.add(num);
        }
        Collections.sort(list);
    }
}
