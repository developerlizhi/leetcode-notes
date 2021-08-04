package com.developerlizhi.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution015 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSumLeetCode(nums).toString());
    }

    public static List<List<Integer>> threeSumLeetCode(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < len; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = len - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < len; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        // 排序避免重复
        Arrays.sort(nums);
        int first = 0, second = 0, third = 0;
        int len = nums.length;

        List<List<Integer>> ans = new ArrayList<>();

        // 第一层循环从 0 -> n-1
        for (first = 0; first < len - 1; first++) {
            if (first == 0 || nums[first] != nums[first - 1]) {

                // 第二层循环从 1 -> n-1
                for (second = first + 1; second <= len - 1; second++) {
                    if (second == first + 1 || nums[second] != nums[second - 1]) {

                        // 第三层循环从 2 -> n-1
                        for (third = second + 1; third <= len - 1; third++) {
                            if (third == second + 1 || nums[third] != nums[third - 1]) {
                                if (nums[first] + nums[second] == -(nums[third])) {
                                    List<Integer> numsList = new ArrayList<>();
                                    numsList.add(nums[first]);
                                    numsList.add(nums[second]);
                                    numsList.add(nums[third]);
                                    ans.add(numsList);
                                }
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
