package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution050 {

    public static void main(String[] args) {
        //        System.out.println(myPow(2.00000, 10));
        //        System.out.println(myPow(2.10000, 3));
        //        System.out.println(myPow(2.00000, -2));
        //        System.out.println(myPow(0.44528, 0));
        //        System.out.println(myPow(1.00000, 2147483647));
        // System.out.println(myPow(2.00000, -2147483647));
        //        System.out.println(myPow(-1.00000, 2147483647));
        //        System.out.println(-1 % 2);
    }

    public static double myPowTimeOut(double x, int n) {

        double result = 0;

        if (x == 1) {
            return 1;
        } else if (x == -1) {
            return (n % 2) == 1 ? -1 : 1;
        }

        if (n == 0) {
            return 1;
        } else if (n < 0) {
            result = 1 / calc(x, Math.abs(n));
        } else {
            result = calc(x, n);
        }
        return result;
    }

    public static double calc(double x, int n) {

        double ans = x;
        for (int i = 0; i < n - 1; i++) {
            ans = x * ans;
            if (ans >= Double.MAX_VALUE) {
                return Double.MAX_VALUE;
            }
        }
        return ans;
    }

    public double myPowLeetCode01(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulLeetCode01(x, N) : 1.0 / quickMulLeetCode01(x, -N);
    }

    public double quickMulLeetCode01(double x, long N) {
        if (N == 0) {
            return 1.0;
        }
        double y = quickMulLeetCode01(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPowLeetCode02(double x, int n) {
        long N = n;
        return N >= 0 ? quickMulLeetCode02(x, N) : 1.0 / quickMulLeetCode02(x, -N);
    }

    public double quickMulLeetCode02(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
