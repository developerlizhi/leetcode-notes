package com.developerlizhi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution003 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("  "));
    }

    public static int lengthOfLongestSubstring(String s) {

        char[] array = s.toCharArray();
        int len = array.length;

        if (len == 0) {
            return 0;
        }

        int first = 0, second = 0;

        int ans = 0;

        for (first = 0; first < len; first++) {

            Set<Character> set = new HashSet<>();
            set.add(array[first]);

            for (second = first + 1; second < len; second++) {
                if (set.contains(array[second])) {
                    break;
                } else {
                    set.add(array[second]);
                }
            }
            if (ans < set.size()) {
                ans = set.size();
            }
        }
        return ans;
    }
}
