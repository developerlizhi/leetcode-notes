package com.developerlizhi.leetcode;

/**
 * @author developerlizhi
 * @date 2021-04-22 11:32:36
 */
public class Solution021 {

    public static void main(String[] args) {

        ListNode node =
                mergeTwoListsLeetCode01(
                        new ListNode(1, new ListNode(2, new ListNode(4))),
                        new ListNode(1, new ListNode(3, new ListNode(4))));
        //        ListNode node0 = mergeTwoLists(null, new ListNode(0));
        //        ListNode node1 = mergeTwoLists(new ListNode(2), new ListNode(1));
        //        ListNode node2 = mergeTwoLists(new ListNode(1), new ListNode(2));
        //        ListNode node3 = mergeTwoListsLeetCode01(new ListNode(-9, new ListNode(3)), new
        // ListNode(5, new ListNode(7)));
        System.out.println(123);
    }

    public static ListNode mergeTwoListsLeetCode01(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoListsLeetCode01(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoListsLeetCode01(l1, l2.next);
            return l2;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        // 伪头结点
        ListNode prevHead = new ListNode(-1);
        ListNode prev = prevHead;

        // 正文开始
        while (null != l1 && null != l2) {

            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 可能至多剩下一个链表未能循环完，由于一定为升序，直接指定即可
        prev.next = l1 == null ? l2 : l1;
        return prevHead.next;
    }

    //    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //
    //        if (null == l1) {
    //            return l2;
    //        }
    //
    //        if (null == l2) {
    //            return l1;
    //        }
    //
    //        // 正文开始
    //        while (null != l1) {
    //            l2 = addNode(l2, l1.val);
    //            l1 = l1.next;
    //        }
    //        return l2;
    //    }
    //
    //    public static ListNode addNode(ListNode l, int val) {
    //
    //        ListNode node = new ListNode(val);
    //
    //        while (null != l) {
    //
    //            if (null == l.next) {
    //
    //                if (val < l.val) {
    //                    node.next = l;
    //                    l = node;
    //                    return l;
    //                }
    //
    //                l.next = node;
    //                break;
    //            }
    //
    //            if (val < l.val) {
    //                node.next = l;
    //                l = node;
    //                return l;
    //            }
    //
    //            if (val <= l.next.val) {
    //                node.next = l.next;
    //                l.next = node;
    //                break;
    //            }
    //            l = l.next;
    //        }
    //        return l;
    //    }
}
