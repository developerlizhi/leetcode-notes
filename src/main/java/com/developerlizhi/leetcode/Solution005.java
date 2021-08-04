package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution005 {

    public static void main(String[] args) {

        //        String a = "bb";
        //        System.out.println(a.charAt(0));
        //        System.out.println(a.charAt(1));
        //
        //
        //        System.out.println(longestPalindrome("babad"));
        //        System.out.println(longestPalindrome("cbbd"));
        //        System.out.println(longestPalindrome("a"));
        //        System.out.println(longestPalindrome("bb"));
        //        System.out.println(longestPalindrome("ac"));
        //        System.out.println(longestPalindrome("abb"));
        System.out.println(longestPalindromeLeetCode("aaaac"));
        char a = 1;
    }

    public static String longestPalindromeLeetCode(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }

    public String longestPalindrome1(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int strLen = s.length();
        int left = 0;
        int right = 0;
        int len = 1;
        int maxStart = 0;
        int maxLen = 0;

        for (int i = 0; i < strLen; i++) {
            left = i - 1;
            right = i + 1;
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {
                len++;
                left--;
            }
            while (right < strLen && s.charAt(right) == s.charAt(i)) {
                len++;
                right++;
            }
            while (left >= 0 && right < strLen && s.charAt(right) == s.charAt(left)) {
                len = len + 2;
                left--;
                right++;
            }
            if (len > maxLen) {
                maxLen = len;
                maxStart = left;
            }
            len = 1;
        }
        return s.substring(maxStart + 1, maxStart + maxLen + 1);
    }
}
