package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class addTwoNumbers2 {
    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{7, 0, 8},
                OjUtils.travelListNode(addTwoNumbers(
                        OjUtils.newListNodeFromArrays(new Integer[]{2, 4, 3}),
                        OjUtils.newListNodeFromArrays(new Integer[]{5, 6, 4})), 3));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0;
        int n2 = 0;
        int jin = 0;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            n1 = l1 == null ? 0 : l1.val;
            n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + jin;
            ListNode bit = new ListNode(sum % 10);
            jin = sum / 10;
            curr = curr.next = bit;
            l1 = (l1 == null ? null : l1.next);
            l2 = (l2 == null ? null : l2.next);
        }
        if (jin != 0) {
            curr.next = new ListNode(jin);
        }
        return dummy.next;
    }
}
