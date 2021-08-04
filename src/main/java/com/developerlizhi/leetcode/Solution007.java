package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution007 {

    public static void main(String[] args) {
        //        System.out.println(reverse(123));
        //        System.out.println(reverse(-123))

        //        int a = 1534236469;
        //        System.out.println(a);
    }

    public static int reverse02(int x) {

        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static int reverse03(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static int reverse01(int x) {

        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x /= 10;
        }
        return (int) n == n ? (int) n : 0;
    }
}
