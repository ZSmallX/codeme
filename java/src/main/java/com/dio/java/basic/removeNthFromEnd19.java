package com.dio.java.basic;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class removeNthFromEnd19 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4},
                OjUtils.travelListNode(
                        removeNthFromEnd(OjUtils.newListNodeFromArrays(1, 2, 3, 4, 5), 1), 4)
        );
    }

    // 一次遍历，仅记录目标节点的指针值。
    // 时间O(n) 空间O(1)
    // 优化： 同等空间和时间开销的情况下，双指针思路更加简单，不需要处理额外的异常分支。
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int count = 1;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode target = head;
        ListNode curr = head;

        while (curr.next != null) {
            count++;
            if (count > n) {
                prev = target;
                target = target.next;
            }
            curr = curr.next;
        }

        if (target.next != null) {
            target.val = target.next.val;
            target.next = target.next.next;
        } else {
            prev.next = null;
        }

        return dummy.next;
    }

    // 双指针
    // 开销：时间O(n) 空间O(1)
    // 找到其前一个节点，便于删除
    // 使用dummy处理「双指针仅一个节点的情况」
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }


        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
