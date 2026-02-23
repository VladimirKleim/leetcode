package yandex_leetcode.src.main.java.temp;

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"} ));
        System.out.println(groupAnagrams(new String[]{"car", "rac", "cra", "feed", "deef", "fede"} ));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sSort = new String(charArray);
            map.putIfAbsent(sSort, new ArrayList<>());
            map.get(sSort).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
