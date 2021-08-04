package com.developerlizhi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution001 {

    //    示例 1：
    //
    //    输入：nums = [2,7,11,15], target = 9
    //    输出：[0,1]
    //    解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
    //    示例 2：
    //
    //    输入：nums = [3,2,4], target = 6
    //    输出：[1,2]
    //    示例 3：
    //
    //    输入：nums = [3,3], target = 6
    //    输出：[0,1]

    public static void main(String[] args) {

        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 2, 4};
        int[] nums3 = {3, 3};

        System.out.println(Arrays.toString(twoSum01(nums1, 9)));
        System.out.println(Arrays.toString(twoSum01(nums2, 6)));
        System.out.println(Arrays.toString(twoSum01(nums3, 6)));

        System.out.println();
        System.out.println(Arrays.toString(twoSum02(nums1, 9)));
        System.out.println(Arrays.toString(twoSum02(nums2, 6)));
        System.out.println(Arrays.toString(twoSum02(nums3, 6)));
    }

    public static int[] twoSum01(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum02(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i <= nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
