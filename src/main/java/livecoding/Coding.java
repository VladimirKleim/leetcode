package yandex_leetcode.src.main.java.livecoding;

import yandex_leetcode.src.main.java.livecoding.special.ListNode;
import yandex_leetcode.src.main.java.livecoding.special.TreeNode;

import java.util.*;

public class Coding implements Algorithmable {

    public static void main(String[] args) {

    }

    @Override
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }

    @Override
    public ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode dummy = list;

        if (list1 == null && list2 == null) {
            return null;
        }

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = (list1 != null) ? list1 : list2;
        return list.next;
    }



    @Override
    public int  maxSubArray(int[] nums) {
        int maxSub = nums[0], curSum = 0;
        for (Integer num : nums) {
            if (curSum < 0) {
                curSum = 0;
            }
            curSum += num;
            maxSub = Math.max(maxSub, curSum);
        }
        return maxSub; // Kadane's Algorithm
    }

    @Override
    public int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    @Override
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode list = head;
        while (list != null) {
            ListNode nextPrev = list.next;
            list.next = prev;
            prev = list;
            list = nextPrev;
        }
        return prev;
    }

    @Override
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    @Override
    public boolean isPalindrome(String s) {
        for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
            // Пропускаем не-буквенно-цифровые символы слева
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return 0;
    }

    @Override
    public List<String> summaryRanges(int[] nums) {
        List<String> dummy = new ArrayList<>();
        if (nums.length == 0) {
            return dummy;
        }
        int start = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            if (i == nums.length || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    dummy.add(String.valueOf(start));
                } else {
                    dummy.add(start + "->" + nums[i - 1]);
                }
                if (i < nums.length) {
                    start = nums[i];
                }
            }
        }
        return dummy;
    }

    @Override
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    @Override
    public boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        return (r1.val == r2.val) && isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left);

    }

    @Override
    public int[] concatenation(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n * 2];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = arr[i + n] = nums[i];
        }
        return arr;
    }

    @Override
    public void moveZeroes(int[] nums) {
        int nullPointer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[nullPointer];
                nums[nullPointer] = nums[i];
                nums[i] = temp;
                nullPointer++;
            }
        }
    }

    @Override
    public boolean lineReflection(int[][] nums) {
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;

        Set<List<Integer>> points = new HashSet<>();
        for (int[] point : nums) {
            minX = Math.min(minX, point[0]);
            maxX = Math.max(maxX, point[0]);

            points.add(List.of(point[0], point[1]));
        }

        int sum = minX + maxX;

        for (int[] point : nums) {
            // (x, y) -> (sum - x, y)
            int reflectedX = sum - point[0];
            if (!points.contains(List.of(reflectedX, point[1]))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    @Override
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sMap.equals(tMap);
    }

    @Override
    public boolean isParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);
            if (!map.containsKey(sym)) {
                stack.push(sym);
            } else {
                char top = stack.isEmpty() ? '?' : stack.pop();
                if (top != map.get(sym)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    @Override
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }

    @Override
    public boolean isIsomorphic(String s, String t) {
         Map<Character, Character> sMap = new HashMap<>();
         Map<Character, Character> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
          if (sMap.containsKey(c1) && sMap.get(c1) != c2 ||
              tMap.containsKey(c2) && tMap.get(c2) != c1) {
              return false;
          }
          sMap.put(c1, c2);
          tMap.put(c2, c1);
        }
        return true;
    }

    @Override
    public int longestSubarray(int[] nums) {
        int left = 0;
        int max_length = 0;
        int zero_slide = -1;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                left = zero_slide + 1;
                zero_slide = right;
            }
            max_length = Math.max(max_length, right - left);
        }
        return max_length;
    }

    @Override
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();

        Set<Integer> set2 = new HashSet<>();

        List<List<Integer>> list = new ArrayList<>();

        list.add(new ArrayList<>());
        list.add(new ArrayList<>());

        for (int i : nums1) {
            set1.add(i);
        }

        for (int i : nums2) {
            set2.add(i);
        }

        for (int i : set1) {
            if (!set2.contains(i)) {
                list.get(0).add(i);
            }
        }
        for (int i : set2) {
            if (!set1.contains(i)) {
                list.get(1).add(i);
            }
        }

        return list;
    }

    // String s = 'abc'
    // String t = 'ahbfsc'

    //O(n + m) Time complexity
    //O(1) Memory space complexity
    @Override
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0 && t.length() == 0) {
            return true;
        }
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }
        return sp == s.length();
    }


    //-----------------------------
    @Override
    public boolean validPalindrome2(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome2(s, left + 1, right) || isPalindrome2(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    @Override
    public boolean isPalindrome2(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    //-----------------------------
    @Override
    public int maxDistToClosest(int[] seats) {
        int max_gap = 0;
        int prev = -1;
        int seatLength = seats.length - 1;

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max_gap = Math.max(max_gap, i);
                } else {
                    max_gap = Math.max(max_gap, (i - prev) / 2);
            }
                prev = i;
           }

        }
        if (seats[seatLength] == 0) {
            max_gap = Math.max(max_gap, seats.length - 1 - prev);
        }

        return max_gap;
    }

    @Override
    //Time complexity : O(n)
    //Space complexity : O(1)
    public int compress(char[] chars) {
        int ans = 0;
        for (int i = 0; i < chars.length; ) {
            char letter = chars[i];
            int count = 0;
            while (i < chars.length && letter == chars[i]) {
                ++count;
                ++i;
            }
            chars[ans++] = letter;
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[ans++] = c;
                }
            }
        }
        return ans;
    }

    @Override
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                list.add(entry.getKey());
            }
        }
        return list;
    }

    @Override
    //Sliding window
    public boolean permutationString(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            s1Map.put(s1.charAt(i), s1Map.getOrDefault(s1.charAt(i),0) + 1);
            s2Map.put(s2.charAt(i), s2Map.getOrDefault(s2.charAt(i),0) + 1);
        }

        if (s1Map.equals(s2Map)) {
            return true;
        }

        int left = 0;
        for (int right = s1.length(); right < s2.length(); right++) {
            char rightChar = s2.charAt(right);
            s2Map.put(rightChar, s2Map.getOrDefault(rightChar, 0) + 1);

            char leftChar = s2.charAt(left);
            s2Map.put(leftChar, s2Map.get(leftChar) - 1);
            if (s2Map.get(leftChar) == 0) {
                s2Map.remove(leftChar);
            }
            left++;

            if (s1Map.equals(s2Map)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }

        if (m > n) {
            return isOneEditDistance(t, s);
        }
          for (int i = 0; i < m; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    if (m == n) {
                        return s.substring(i + 1).equals(t.substring(i + 1));
                    }
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        return m != n;
    }

    @Override
    public int findMaxConsecutiveOnes1(int[] nums) {
        int res = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            cur = (nums[i] == 1) ? cur + 1 : 0;
            res = Math.max(res, cur);

        }
        return res;
    }

    @Override
    public int findMaxConsecutiveOnes2(int[] nums) {
        int flip = 0;
        int notFlip = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                flip++;
                notFlip++;
            } else {
                flip = notFlip + 1;
                notFlip = 0;
            }
            max = Math.max(max, Math.max(flip, notFlip));
        }

        return max;
    }

    @Override
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    @Override
    public List<List<String>> groupAnagrams(String[] strs) {
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

    @Override
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int total = 0, count = 0;

        for (int num : nums) {
            total += num;

            if (map.containsKey(total - k)) {
                count += map.get(total - k);
            }
            map.put(total, map.getOrDefault(total, 0) + 1);
        }

        return count;
    }

    @Override
    public int[] intersectionArrays1(int[] nums1, int[] nums2) {
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

    @Override
    public int[] intersection2(int[] nums1, int[] nums2) {
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

    @Override
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    @Override
    public boolean judgeCircle(String moves) {
        int UpDown = 0;
        int LeftRight = 0;

        for (char i : moves.toCharArray()) {
            if (i == 'U') {
                UpDown++;
            }
            else if (i == 'D') {
                UpDown--;
            }
            else if (i == 'R') {
                LeftRight++;
            }
            else if (i == 'L') {
                LeftRight--;
            }

        }
        return (LeftRight == 0 & UpDown == 0);
    }

    @Override
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += mat[i][i] + mat[i][n - i - 1];
        }

        if (n % 2 == 1) {
            result -= mat[n / 2][n / 2];
        }
        return result;
    }

    @Override
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSameTreeMirror(p, q);
    }

    @Override
    public boolean isSameTreeMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTreeMirror(p.left, q.left) && isSameTreeMirror(p.right, q.right);
    }

    @Override
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }
        }
        return profit;
    }

    @Override
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    @Override
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //TODO
    }

    @Override
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int i = 1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    @Override
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] < prev[1]) {
                prev[1] = Math.max(intervals[i][1], prev[1]);
            } else {
                merged.add(prev);
                prev = intervals[i];
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    @Override
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (arr.length < 3) {
            return false;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left + 1 < right && arr[left] < arr[left + 1]) {
            left++;
        }
        while (right - 1 > 0 && arr[right] < arr[right - 1]) {
            right--;
        }
        return left == right;
    }

    @Override
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int ans = 0;
        for (int num : arr1) {
            boolean isValid = true;
            int left = num - d;
            int right = num + d;
            for (int num2 : arr2) {
                if (num2 >= left && num2 <= right) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                ans++;
            }
        }
        return ans;
    }

    @Override
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    @Override
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    @Override
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }

    @Override
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {continue;}
                String squareCase = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c])
                        || columns.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c])
                        || square.computeIfAbsent(squareCase, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
                columns.get(c).add(board[r][c]);
                square.get(squareCase).add(board[r][c]);
            }
        }
        return true;
    }

    @Override
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}
