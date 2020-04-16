package com.dio.java.bytedance;

import org.junit.Assert;
import org.junit.Test;

import oj.scaffold.ListNode;
import oj.scaffold.OjUtils;

public class reverseList206 {
    ListNode newHead = null;
    ListNode curr = null;

    @Test
    public void test() {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5},
                OjUtils.travelListNode(reverseList(OjUtils.newListNodeFromArrays(new Integer[]{5, 4, 3, 2, 1})), 5));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        return newHead;
    }

    private void dfs(ListNode node) {
        if (node.next == null) {
            newHead = new ListNode(node.val);
            curr = newHead;
        } else {
            dfs(node.next);
            ListNode nextNode = new ListNode(node.val);
            curr = curr.next = nextNode;
        }
    }
}
