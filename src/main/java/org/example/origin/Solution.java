package org.example.origin;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Solution main = new Solution();
        String s = "jbpnbwwd";
        System.out.println(main.lengthOfLongestSubstring(s));

    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), longest = 0;
        int[] nextIndex = new int[128];
        for (int r = 0, l = 0; r < n; r++) {
            l = Math.max(nextIndex[s.charAt(r)], l);
            System.out.print("nextIdx = " + nextIndex[s.charAt(r)]);
            longest = Math.max(longest, r - l + 1);
            System.out.print(" ; longest = " + longest + " ; l = " + l + "\n");
            nextIndex[s.charAt(r)] = r + 1;
        }
        return longest;
    }

//    public int lengthOfLongestSubstring(String s) {
//        int start = 0, result = 0;
//        int max = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            start = Math.max(start, map.getOrDefault(ch, -1) + 1);
//            result = Math.max(result, i - start + 1);
//            map.put(ch, i);
//        }
//        return result;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        int left = 0, right = 0;
//        int max = 0;
//        HashSet<Character> set = new HashSet<>();
//        while (right < s.length()) {
//            while (!set.add(s.charAt(right))) {
//                set.remove(s.charAt(left));
//                left++;
//            }
//            right++;
//            max = Math.max(max, set.size());
//        }
//        return max;
//    }

//    public int lengthOfLongestSubstring(String s) {
//        HashSet<Character> set = new HashSet<>();
//        int count = 0;
//        int max = 0;
//        char[] a = s.toCharArray();
//        for (int i = 0; i < a.length; i++) {
//            for (int j = i; j < a.length; j++) {
//                if (!set.add(a[j])) {
//                    if (max < count) max = count;
//                    count = 0;
//                    set.clear();
//                    break;
//                }
//                count++;
//                System.out.println("Max = " + max + " , char = " + a[j] + " ; i = " + i + " ; j = " + j);
//                if (i == a.length - 1 && max < count) max = count;
//            }
//        }
//        return max;
//    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int first = target - nums[i];
            if (i > 0 && map.get(first) != null) return new int[]{i, map.get(first)};
            map.put(nums[i], i);
        }
        return null;
    }
//    public int[] twoSum(int[] nums, int target) {
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            int first = target - nums[i];
//            if (i > 0) {
//                if (map.get(first) != null) return new int[]{i, map.get(first)};
//            }
//            map.put(nums[i], i);
//        }
//        return null;
//    }
}
