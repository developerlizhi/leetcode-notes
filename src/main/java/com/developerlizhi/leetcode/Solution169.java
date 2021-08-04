package com.developerlizhi.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author developerlizhi
 * @title leetcode - 169 - 多数元素
 * @level EASY
 * @url https://leetcode-cn.com/problems/majority-element/
 * @solution 哈希表|排序|随机化|分治|Boyer-Moore 投票算法
 * @date 2021-08-04 16:13:32
 */
public class Solution169 {

    public static void main(String[] args) {
        ListNode head;
        while (head != null) {
            head = head.next;
        }
    }

    /**
     * @solution 哈希表
     * @url https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * @complexity 时间复杂度：O(n) 空间复杂度：O(n)
     * 时间复杂度：O(n)，其中 n 是数组 nums 的长度。我们遍历数组 nums 一次，对于 nums 中的每一个元素，将其插入哈希表都只需要常数时间。
     * 空间复杂度：O(n)，哈希表中占用的空间为 O(n)。
     * @remark 使用哈希表来数字出现的次数，然后遍历返回最大的值。
     * @hint 可以尝试维护最大值，即可减少一次遍历。
     */
    public int majorityElement01(int[] nums) throws Exception {

        Map<Integer, Integer> counts = new HashMap<>();

        // 统计数字出现次数
        for (Integer num : nums) {
            if (counts.containsKey(num)) {
                counts.put(num, counts.get(num) + 1);
            } else {
                counts.put(num, 1);
            }
        }

        // 遍历集合中值最大的 entry，并返回 key 值
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        if (null == majorityEntry) {
            throw new Exception("error");
        }

        return majorityEntry.getKey();
    }

    /**
     * @solution 排序
     * @url https://leetcode-cn.com/problems/majority-element/solution/duo-shu-yuan-su-by-leetcode-solution/
     * @complexity 时间复杂度：O(n log n) 空间复杂度：O(log n)
     * 时间复杂度：O(n log n)，Arrays.sort() 时间复杂度为 O(n logn)
     * 空间复杂度：O(log n)，Arrays.sort() 需要 O(log n) 的栈空间。
     * @remark 据题，多数元素是在数组中出现次数 大于 [ n / 2 ]的元素。那么将数组排序后，众数一定在排序后数组的中间位置，取出即可。
     * 由于众数在数组中间前后，所以无需顾虑数组的奇偶数个数问题。
     * @hint 如果自己编写堆排序，则只需要使用 O(1) 的额外空间。
     */
    public int majorityElement02(int[] nums) {
        // 数组排序算法：时间复杂度：O(nlogn)，空间复杂度：O(logn)
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    // TODO 随机化
    public int majorityElement03(int[] nums) {
        return 0;
    }

    // TODO 分治
    public int majorityElement04(int[] nums) {
        return 0;
    }

    // TODO Boyer-Moore 投票算法
    public int majorityElement05(int[] nums) {
        return 0;
    }
}
