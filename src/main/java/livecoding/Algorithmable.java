package yandex_leetcode.src.main.java.livecoding;

//        200. Number of Islands — количество островов (DFS/BFS).
//        146. LRU Cache — дизайн кеша.
//        1116. Print Zero Even Odd - параллельный вывод чисел потоками

import yandex_leetcode.src.main.java.livecoding.special.ListNode;
import yandex_leetcode.src.main.java.livecoding.special.TreeNode;

import java.util.List;

//min stack
//lru cache
public interface Algorithmable {

    int[] twoSum(int[] nums, int target); //5 +
    ListNode mergeLists(ListNode list1, ListNode list2); //8 +
    int maxSubArray(int[] nums); // 5 +
    int climbStairs(int n); //3 +
    boolean hasCycle(ListNode head); //5 +
    ListNode reverseList(ListNode list); // 5 + второй вариант
    int search(int[] nums, int target); //9 +
    //--------------------------------------------------------
    boolean isPalindrome(String s); //125
    int singleNumber(int[] nums); //5
    List<String> summaryRanges(int[] nums); //8
    boolean isSymmetric(TreeNode root); //6
    boolean isMirror(TreeNode r1, TreeNode r2); //6
    int[] concatenation(int[] nums);
    void moveZeroes(int[] nums); //7
    boolean lineReflection(int[][] nums); // 6
    void reverseString(char[] s); //6
    boolean isAnagram(String s, String t); //4
    boolean isParentheses(String s); //5
    int missingNumber(int[] nums); //4
    boolean isIsomorphic(String s, String t); //5
    int longestSubarray(int[] nums); //4
    List<List<Integer>> findDifference(int[] nums1, int[] nums2); // +
    boolean isSubsequence(String s, String t); //
    boolean validPalindrome2(String s);
    boolean isPalindrome2(String s, int left, int right);

    int maxDistToClosest(int[] seats); //
    boolean permutationString(String s1, String s2); //567. Permutation String
    boolean isOneEditDistance(String s, String t); //640 LintCode
    int findMaxConsecutiveOnes1(int[] nums); //485
    int findMaxConsecutiveOnes2(int[] nums); //883
    int removeElement(int[] nums, int val); //27
    List<List<String>> groupAnagrams(String[] strs);
    int subarraySum(int[] nums, int k);
    int[] intersectionArrays1(int[] nums1, int[] nums2);
    int[] intersection2(int[] nums1, int[] nums2);
    int sumOfLeftLeaves(TreeNode root);
    boolean judgeCircle(String moves); //Robot return to origin
    int diagonalSum(int[][] mat);
    int busyStudent(int[] startTime, int[] endTime, int queryTime); //1450
    boolean isSameTree(TreeNode p, TreeNode q); //Same Tree
    boolean isSameTreeMirror(TreeNode p, TreeNode q);
    int maxProfit(int[] prices); //kadane's alg


    int lengthOfLongestSubstring(String s); // 3
    void merge(int[] nums1, int m, int[] nums2, int n); //88
    int compress(char[] chars); //443
    List<Integer> findDuplicates(int[] nums); //442
    int removeDuplicates(int[] nums); //26
    int[][] merge(int[][] intervals); //56
    boolean validMountainArray(int[] arr); //941
    int findTheDistanceValue(int[] arr1, int[] arr2, int d); //1385
    ListNode removeNthFromEnd(ListNode head, int n); //19
    ListNode middleNode(ListNode head); //876
    ListNode deleteDuplicates(ListNode head); //83
    boolean isValidSudoku(char[][] board); //36
    int searchInsert(int[] nums, int target); //35




}
