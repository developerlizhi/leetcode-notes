package com.developerlizhi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author developerlizhi
 * @title leetcode - 001 - 两数之和
 * @level EASY
 * @url https://leetcode-cn.com/problems/two-sum/
 * @solution 暴力枚举|哈希表
 * @date 2021-04-22 11:32:36
 */
public class Solution001 {

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

    /**
     * @solution 暴力枚举
     * @url https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * @complexity 时间复杂度：O(n^2) 空间复杂度：O(1)
     * 时间复杂度：O(n^2)，其中 n 是数组中的元素数量。最坏情况下数组中任意两个数都要被匹配一次。
     * 空间复杂度：O(1)
     * @remark 通过暴力枚举，不断尝试找到所有的可能，效率最差，但却最简单。
     */
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

    /**
     * @solution 哈希表
     * @url https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
     * @complexity 时间复杂度：O(n) 空间复杂度：O(n)
     * 时间复杂度：O(n)，其中 n 是数组中的元素数量。对于每一个元素 x，我们可以 O(1) 地寻找 target - x。
     * 空间复杂度：O(n)，其中 n 是数组中的元素数量。主要为哈希表的开销。
     * @remark 注意到方法一的寻找 target - x 的时间复杂度过高，使用哈希表，可以将寻找 target - x 的时间复杂度降低到从 O(n) 降低到 O(1)。
     * 我们创建一个哈希表，对于每一个 x，都在哈希表中查找是否存在 target - x，然后将 x 存入哈希表中，只需要遍历一次，即可得出结果。
     * @hint 以空间换时间
     */
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
