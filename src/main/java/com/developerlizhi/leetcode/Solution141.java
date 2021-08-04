package com.developerlizhi.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author developerlizhi
 * @title leetcode - 053 - 环形链表
 * @level EASY
 * @url https://leetcode-cn.com/problems/linked-list-cycle/
 * @solution 哈希表|链表|双指针
 * @date 2021-08-04 16:13:32
 */
public class Solution141 {

    public static void main(String[] args) {
    }

    /**
     * @solution 哈希表
     * @url https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
     * @complexity 时间复杂度：O(n) 空间复杂度：O(n)
     * 时间复杂度：O(n)，其中 n 是链表中的节点数。最坏情况下我们需要遍历每个节点一次。
     * 空间复杂度：O(n)，其中 n 是链表中的节点数。主要为哈希表的开销，最坏情况下我们需要将每个节点插入到哈希表中一次。
     * @remark 使用哈希表来存储所有已经访问过的节点。
     * 每次我们到达一个节点，如果该节点已经存在与哈希表中，则说明该链表为环形链表，否则就将该节点加入哈希表中。
     * 重复这一过程，直到遍历完整个链表即可。
     */
    public boolean hasCycle01(ListNode head) {
        Set<ListNode> sets = new HashSet<>();
        // 每个节点只可到达一次，如果存在节点能够到达多次，则为环形链表
        for (ListNode p = head; p != null; p = p.next) {
            if (!sets.add(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @solution 快慢指针（推荐解法）
     * @url https://leetcode-cn.com/problems/linked-list-cycle/solution/huan-xing-lian-biao-by-leetcode-solution/
     * @complexity 时间复杂度：O(n) 空间复杂度：O(1)
     * 时间复杂度：O(n)，其中 n 是链表中的节点数。
     * 当链表中不存在环时，快指针将先于慢指针到达链表尾部，链表中每个节点至多被访问两次。
     * 当链表中存在环时，每一轮移动后，快慢指针的距离将减小一。而初始距离为环的长度，因此至多移动 n 轮。
     * 空间复杂度：O(1)。我们只使用了两个指针的额外空间。
     * @remark 我们定义两个指针，分别为快指针和慢指针，慢指针每次移动 1 个节点，快指针每次移动 2 个节点。
     * 如果慢指针追上快指针，那么必为环形链表。
     */
    public boolean hasCycle02(ListNode head) {

        // 使用快慢指针需要保证至少有两个节点
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != fast) {

            // 移动时确保节点不为空，如果为空，则说明已经遍历到头，不存在环形链表
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
