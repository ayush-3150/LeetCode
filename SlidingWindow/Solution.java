package Leetcode.SlidingWindow;

import java.util.HashMap;

class Solution {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

// Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
        System.out.println("The minimum window substring is " + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {

        String ans = "";
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int x = 0; x < t.length(); x++) {
            map.put(t.charAt(x), map.getOrDefault(t.charAt(x), 0) + 1);

        }
        int count = map.size();
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0)
                    count -= 1;
            }
            while (count == 0) {
                if (min > j - i + 1) {
                    min = Math.min(min, j - i + 1);
                    ans = s.substring(i, i + j - i + 1);
                }
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                    if (map.get(s.charAt(i)) == 1)
                        count++;
                }
                i++;
            }
            j++;
        }
        return ans;

    }
}