package com.developerlizhi.swordForOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 03. 数组中重复的数字 题目链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 解法：哈希表 | 原地置换
 *
 * @author developerlizhi
 * @date 2021-06-29 15:11:08
 */
public class Solution003 {

    public static void main(String[] args) {
        int[] testNums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int result = findRepeatNumber(testNums);
        System.out.println(result);
    }

    /*
     * 官方题解 哈希表/Set
     * 时间复杂度 O(n) 空间复杂度 O(n)
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-b-4/
     */
    public static int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return num;
            }
            set.add(num);
        }
        return -1;
    }

    /*
     * 推荐解法 原地置换
     * 时间复杂度 O(n) 空间复杂度 O(1)
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/solution/mian-shi-ti-03-shu-zu-zhong-zhong-fu-de-shu-zi-yua/
     */
    public static int findRepeatNumber02(int[] nums) {
        int i = 0;
        while (i < nums.length) {

            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
        }
        return -1;
    }
}
