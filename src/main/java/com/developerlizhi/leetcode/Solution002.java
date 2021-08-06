package com.developerlizhi.leetcode;


/**
 * @author developerlizhi
 * @title leetcode - 002 - 两数相加
 * @level EASY
 * @url https://leetcode-cn.com/problems/add-two-numbers/
 * @solution 模拟
 * @date 2021-04-22 11:32:36
 */
public class Solution002 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));
        addTwoNumbers(l1, l2);
    }

    /**
     * @solution 模拟
     * @url https://leetcode-cn.com/problems/add-two-numbers/solution/liang-shu-xiang-jia-by-leetcode-solution/
     * @complexity 时间复杂度：O(n) 空间复杂度：O(1)
     * 时间复杂度：O(n)，我们要遍历两个链表的全部位置，而处理每个位置只需要 O(1) 的时间。
     * 空间复杂度：O(1)，没有额外使用空间
     * @remark 模拟初等数学方法，遍历两个链表，然后注意进位。
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = null, tail = null;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;

            int sum = n1 + n2 + carry;

            carry = sum / 10;

            // 第一次循环时，链表为空，将头尾指针均指到第一个结点
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                // 如果不为空，则新增结点，并移动尾指针
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            // 此处有点难理解，存在进位，新增一个结点，例如 33 + 67 = 101，那么这个进位为 1，就必须要新增一个结点。
            // 如果是 342 + 465 = 807，这种新增一个结点，其实意义不大，这个节点会被下次循环时被覆盖
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }
}
