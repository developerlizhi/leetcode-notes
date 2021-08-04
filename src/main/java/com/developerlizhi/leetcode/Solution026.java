package com.developerlizhi.leetcode;

import java.util.Arrays;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution026 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4};
        System.out.println(removeDuplicates((nums)));
        System.out.println(Arrays.toString(nums));
    }

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }
        return i + 1;
    }
}
