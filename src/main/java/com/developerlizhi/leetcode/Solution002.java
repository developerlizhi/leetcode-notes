package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution002 {

    //    示例 1：
    //    输入：l1 = [2,4,3], l2 = [5,6,4]
    //    输出：[7,0,8]
    //    解释：342 + 465 = 807.
    //    示例 2：
    //
    //    输入：l1 = [0], l2 = [0]
    //    输出：[0]
    //    示例 3：
    //
    //    输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //    输出：[8,9,9,9,0,0,0,1]

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));

        ListNode head = addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            int sum = n1 + n2 + carry;

            carry = sum / 10;

            if (head == null) {
                // 如果为空，则代表头就是尾
                head = tail = new ListNode(sum % 10);
            } else {
                // 如果不为空，则新增元素，并修改坐标
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }
}
