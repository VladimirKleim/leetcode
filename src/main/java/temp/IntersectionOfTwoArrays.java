package yandex_leetcode.src.main.java.temp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//Ввод: nums1 = [1,2,2,1], nums2 = [2,2]
//Вывод: [2]
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(intersectionArrays(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    static class LinkedNode {
        int val;
        LinkedNode next;

        public LinkedNode(){
        }
        public LinkedNode(int val, LinkedNode next) {
            this.val = val;
            this.next = next;
        }

        public static LinkedNode reverseLists(LinkedNode root) {
            if (root == null) {
                return null;
            }
            LinkedNode newHead = root;
            if (root.next != null) {
                newHead = reverseLists(root.next);
                root.next.next = root;
            }
            root.next = null;
            return newHead;
        }

        public static LinkedNode mergeLists(LinkedNode list1, LinkedNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            }
            LinkedNode list = new LinkedNode();
            LinkedNode res = list;
            while (list1.val < list2.val) {
                if (list1.next != null && list2.next != null) {
                    res.next = list1;
                    list1 = list1.next;
                } else {
                    res.next = list2;
                    list2 = list2.next;
                }
                res.next = res;
                res = (list1.next != null) ? list1 : list2;

            }
            return list;
        }
    }

    public static int[] intersectionArrays(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] resultArray = new int[set2.size()];
        int i = 0;
        for(int num : set2) {
            resultArray[i++] = num;
        }
        return resultArray;
    }


}
