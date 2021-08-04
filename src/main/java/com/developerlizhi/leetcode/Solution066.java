package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution066 {

    public static void main(String[] args) {
    }

    public static int mySqrt(int x) {

        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int mySqrtTimeOut(int x) {

        int result = 0;
        int i = 1;
        while (true) {
            result = i * i;
            if (result == x) {
                return i;
            } else if (result > x) {
                return i - 1;
            } else {
                i++;
            }
        }
    }
}
