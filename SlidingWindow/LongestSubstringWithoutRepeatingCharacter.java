package Leetcode.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacter {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Longest Substring Without Repeating Characters is " + lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            char n = s.charAt(j);
            if (hm.containsKey(n)) {
                hm.put(n, hm.get(n) + 1);
            } else {
                hm.put(n, 1);
            }

            if (hm.size() == j - i + 1) {
                max = Math.max(j - i + 1, max);
            }
            if (hm.size() < j - i + 1) {
                while (hm.size() < j - i + 1) {
                    hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                    if (hm.get(s.charAt(i)) == 0) {
                        hm.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;


        }
        return max;
    }
}
