package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @title leetcode - 136 - 只出现一次的数字
 * @level EASY
 * @url https://leetcode-cn.com/problems/single-number/
 * @solution 位运算
 * @date 2021-08-04 16:13:32
 */
public class Solution136 {

    public static void main(String[] args) {
        int[] testNums = new int[]{2, 2, 1};
        int result = singleNumber(testNums);
        System.out.println(result);
    }

    /**
     * @solution 位运算（推荐解法）
     * @url https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode-solution/
     * @complexity 时间复杂度 O(n) 空间复杂度 O(1)
     * 时间复杂度：O(n)，其中 n 是数组长度。只需要对数组遍历一次。
     * 空间复杂度：O(1)
     * @remark 通过位运算，如果数字相同，位运算的结果为 0，0 与任何数位运算结果都为 0 ，故遍历结束后，剩余的数为需要的结果。
     */
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}