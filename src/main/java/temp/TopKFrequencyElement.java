package yandex_leetcode.src.main.java.temp;

import java.util.*;

public class TopKFrequencyElement {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencyElement(new int[]{1,2,3,4,4,4,5,6,5,4,4,7,8,9,4,3,2,1,4,4}, 1)));

    }

    private static int[] frequencyElement(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (Integer num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
          freqMap.forEach((num, freq) -> {
           if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
           buckets[freq].add(num);
        });

          List<Integer> res = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && res.size() < k ; i--) {
            if (buckets[i] != null) res.addAll(buckets[i]);
        }
      return res.stream().mapToInt(i -> i).toArray();
    }
}
